package kotlin.yann.com.myapplication;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;

/**
 * Created by xyy on 2017/11/28.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);
    }
}
