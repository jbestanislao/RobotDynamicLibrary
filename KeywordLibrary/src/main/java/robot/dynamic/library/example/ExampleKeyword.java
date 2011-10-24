package robot.dynamic.library.example;

import org.springframework.stereotype.Component;
import robot.dynamic.library.AbstractRobotKeywordLibrary;
import robot.dynamic.library.aspect.RobotDynamicKeyword;
import robot.dynamic.library.keyword.AbstractRobotKeywords;
import robot.dynamic.library.keyword.RobotKeywords;

@Component("ExampleKeyword")
public class ExampleKeyword extends AbstractRobotKeywords implements RobotKeywords {
    @RobotDynamicKeyword
    public String getMessage() {
        return "Hi, Im John Bryan.";
    }
}
