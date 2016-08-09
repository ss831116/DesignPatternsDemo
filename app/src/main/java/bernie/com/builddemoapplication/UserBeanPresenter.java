package bernie.com.builddemoapplication;

import android.content.SharedPreferences;

/**
 * Created by bernie.shi on 2016/8/8.
 */

public class UserBeanPresenter implements Observer<UserBean>{

    Presenter<UserBean> presenter;

    public UserBeanPresenter(UserBean userBean,Presenter<UserBean> presenter,SharedPreferences sharedPreferences,SharedPreferences.Editor editor){

        this.presenter = presenter;
        final SubObserver subObserver = new ConcreteSubObserver();
        subObserver.add(this);
        new  SetDataToSp(userBean,sharedPreferences,editor,subObserver);
    }

    @Override
    public void updateNotify(UserBean userBean) {
        presenter.like(userBean);
    }
}
