package kotlin.yann.com.myapplication;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by xyy on 2017/11/20.
 */

public class UIUtilts {

    public static final int STANDARD_WIDTH=1080;
    public static final int STANDARD_HEIGHT = 1872;
    private static final String DIMEN_CLASS = "com.android.internal.R$dimen";

    public float displayMetricsWidth;
    public float displayMetricsHeight;

    private UIUtilts(Context context){
        //获取屏幕的真是高宽
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();

        if(displayMetricsWidth == 0.0f || displayMetricsHeight== 0.0f ){
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            //获取到状态栏的高度
            getSystemBarHeight(context);
        }
    }

    private int getSystemBarHeight(Context context) {
        return getValue(context,"com.android.internal.R$dimen","",48);
    }

    /**
     * android源码中找到存放维度的类
     * @param context
     * @return
     */
    private int getValue(Context context, String attrGroupClass,String attrName,int defaultValue) {
        return defaultValue;
    }
}
