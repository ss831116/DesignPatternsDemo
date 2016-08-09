package bernie.com.builddemoapplication;

/**
 * Created by bernie.shi on 2016/8/8.
 */

public interface Observer<T> {
    public void updateNotify(T t);
}
