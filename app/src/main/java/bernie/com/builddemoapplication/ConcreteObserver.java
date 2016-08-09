package bernie.com.builddemoapplication;

/**
 * Created by bernie.shi on 2016/8/9.
 */

public class ConcreteObserver implements Observer {
    @Override
    public void updateNotify(UserBean userBean) {
        int age = userBean.getAge();
        System.out.println("age = " + age);
    }
}
