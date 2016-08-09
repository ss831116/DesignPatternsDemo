package bernie.com.builddemoapplication;

/**
 * Created by bernie.shi on 2016/8/9.
 */

public interface SubObserver {
    //在其接口中定义一个用来增加观察者的方法
    public void add(Observer observer);
    //再定义一个用来删除观察者权利的方法
    public void remove(Observer observer);
    //再定义一个可以实现行为变现并向观察者传输信息的方法
    public void notifyWatcher(UserBean userBean);
}
