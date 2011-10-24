package robot.dynamic.library.keyword;

import java.util.List;

public interface RobotKeywords {
    List<String> getKeywords();
    String execute(String methodName, Object[] arguments);
}
