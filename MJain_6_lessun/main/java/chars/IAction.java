package chars;

import java.util.List;

public interface IAction {
    void Step(List<Base> group);
    String GetInfo();
}


