package robot.dynamic.library.keyword;

import org.springframework.stereotype.Component;
import robot.dynamic.library.aspect.RobotDynamicKeyword;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRobotKeywords implements RobotKeywords {
    /**
     * Retrieve all keywords from all classes whose methods are marked by
     * {@link RobotDynamicKeyword}
     * @return
     */
    public List<String> getKeywords() {
        List<String> keywords = new ArrayList<String>();

        Class clazz = this.getClass();
        Component component = (Component) clazz.getAnnotation(Component.class);
        try {
            for (Method m : clazz.getMethods()) {
                if (m.isAnnotationPresent(RobotDynamicKeyword.class)) {
                    keywords.add(component.value() + "->" + m.getName());
                }
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
        return keywords;
    }

    /**
     * Execute method.
     * @param methodName
     * @param arguments
     * @return
     */
    public String execute(String methodName, Object[] arguments) {
        Class clazz = this.getClass();
        Method method;
        String value = null;

        try {
            if (arguments != null && arguments.length != 0) {
                method = clazz.getMethod(methodName, Object[].class);
                value = (String) method.invoke(this, new Object[] {arguments});
            } else {
                method = clazz.getMethod(methodName, null);
                value = (String) method.invoke(this, null);
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
