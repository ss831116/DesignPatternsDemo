package bernie.com.builddemoapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bernie.shi on 2016/8/9.
 */

public class ConcreteSubObserver implements  SubObserver{

    private List<Observer> list = new ArrayList<>();
    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyWatcher(UserBean userBean) {
        for (Observer observer : list) {
            observer.updateNotify(userBean);
        }
    }
}
