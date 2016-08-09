package bernie.com.builddemoapplication;

import android.content.SharedPreferences;

/**
 * Created by bernie.shi on 2016/8/8.
 */

public class SetDataToSp {
    public SetDataToSp(UserBean userBean,SharedPreferences sharedPreferences,SharedPreferences.Editor editor,SubObserver subObserver){
        setData(userBean,sharedPreferences,editor,subObserver);
    }
    public void setData(UserBean userBean,SharedPreferences sharedPreferences,SharedPreferences.Editor editor,SubObserver subObserver) {
        int likeCount = sharedPreferences.getInt("like",0);
        editor.putInt("like",++likeCount);
        editor.commit();
        userBean.setLikeCount(sharedPreferences.getInt("like",0));
        subObserver.notifyWatcher(userBean);
    }
}
