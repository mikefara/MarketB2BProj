package com.yann.b2b.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.yann.b2b.application.MyApp;

/**
 * Created by yayun.xia on 2017/12/4.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;

    /**
     * 是否禁止旋转屏幕
     **/
    private boolean isAllowScreenRoate = true;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;
    /**
     * 是否输出日志信息
     **/
    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();

    /**
     * 沉浸式状态栏
     */
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.base_container);

        isDebug = MyApp.isDebug;
        APP_NAME = MyApp.APP_NAME;
        $Log(TAG + "-->onCreate()");
        try {
            Bundle bundle = getIntent().getExtras();
            initParms(bundle);
            mContextView = LayoutInflater.from(this).inflate(getLayoutId(), null);

//            if (isSetStatusBar) {
//                steepStatusBar();
//            }

            mImmersionBar = ImmersionBar.with(this);
            mImmersionBar.init();   //所有子类都将继承这些相同的属性

            setContentView(mContextView);
            if (!isAllowScreenRoate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            initView(mContextView);
            initData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * [初始化布局]
     *
     * @return 布局资源 ID
     */
    protected abstract int getLayoutId();

    /**
     * [初始化Bundle参数]
     *
     * @param bundle
     */
    protected abstract void initParms(Bundle bundle);

    /**
     * [初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化]
     *
     * @param rootView
     */
    protected abstract void initView(View rootView);

    /**
     * [初始化数据： 在基础数据初始化完成之后可以使用该方法]
     */
    protected void initData() {

    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * View点击
     **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "-->onDestroy()");
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }


    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     * [是否允许屏幕旋转]
     *
     * @param isAllowScreenRoate
     */
    public void setScreenRoate(boolean isAllowScreenRoate) {
        this.isAllowScreenRoate = isAllowScreenRoate;
    }

    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }


}
