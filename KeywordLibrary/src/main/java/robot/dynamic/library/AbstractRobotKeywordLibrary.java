package robot.dynamic.library;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import robot.dynamic.library.keyword.RobotKeywords;

import java.util.ArrayList;
import java.util.List;

public class AbstractRobotKeywordLibrary {
    /** Setting library scope to GLOBAL. */
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    private Resource res;
    private XmlBeanFactory factory;

    public AbstractRobotKeywordLibrary(String robotTestConfig) {
        res = new FileSystemResource(robotTestConfig);
        factory = new XmlBeanFactory(res);
    }

    public String[] getKeywordNames() {
        String[] beanNames = factory.getBeanNamesForType(RobotKeywords.class);
        List<String> keywords = new ArrayList<String>();

        for (int i=0; i<beanNames.length; i++) {
            Object bean = factory.getBean(beanNames[i]);
            RobotKeywords robotKeywords = (RobotKeywords) bean;
            for (String kw : robotKeywords.getKeywords()) {
                keywords.add(kw);
            }
        }

        return keywords.toArray(new String[keywords.size()]);
    }

    public String runKeyword(String name, Object[] arguments) {
        String[] nameValues = name.split("->");
        RobotKeywords robotKeywords = (RobotKeywords) factory.getBean(nameValues[0]);
        return  robotKeywords.execute(nameValues[1], arguments);
    }
}
