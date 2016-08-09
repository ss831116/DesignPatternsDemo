package bernie.com.builddemoapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by bernie.shi on 2016/8/8.
 */

public class SingleUserBeanSP implements SharedPreferences {
    public static SharedPreferences singleUserBeanSP = null;
    public static SharedPreferences getSingleUserBeanSP(Context context){
        if (singleUserBeanSP == null) {
            synchronized (SingleUserBeanSP.class) {
                if (singleUserBeanSP == null) {
                    singleUserBeanSP = context.getSharedPreferences("userBean",
                            Context.MODE_WORLD_WRITEABLE | Context.MODE_WORLD_READABLE);;
                }
            }
        }
        return singleUserBeanSP;
    }
    @Override
    public Map<String, ?> getAll() {
        return null;
    }

    @Nullable
    @Override
    public String getString(String s, String s1) {
        return null;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String s, Set<String> set) {
        return null;
    }

    @Override
    public int getInt(String s, int i) {
        return 0;
    }

    @Override
    public long getLong(String s, long l) {
        return 0;
    }

    @Override
    public float getFloat(String s, float v) {
        return 0;
    }

    @Override
    public boolean getBoolean(String s, boolean b) {
        return false;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {

    }
}
