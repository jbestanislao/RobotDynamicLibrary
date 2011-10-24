package robot.dynamic.library.example;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import robot.dynamic.library.AbstractRobotKeywordLibrary;
import robot.dynamic.library.keyword.RobotKeywords;

import java.util.ArrayList;
import java.util.List;

public class ExampleKeywordLibrary extends AbstractRobotKeywordLibrary {
    public ExampleKeywordLibrary() {
        super("src/test/resources/spring/RobotTestAssembly.xml");
    }
}
