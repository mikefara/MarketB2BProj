package com.yann.b2b.welcome.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.yann.b2b.R;
import com.yann.b2b.base.BaseActivity;

/**
 * Created by yayun.xia on 2017/12/6.
 */

@SuppressLint("Registered")
public class SplashActivity extends BaseActivity{
    /**
     * [初始化布局]
     *
     * @return 布局资源 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    /**
     * [初始化Bundle参数]
     *
     * @param bundle
     */
    @Override
    protected void initParms(Bundle bundle) {

    }

    /**
     * [初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化]
     *
     * @param rootView
     */
    @Override
    protected void initView(View rootView) {
        startAnimation(rootView);
    }

    /**
     * View点击
     *
     * @param v
     */
    @Override
    public void widgetClick(View v) {

    }

    /**
     * 启动时缩放、透明、旋转三种动画
     * @param rootView
     */
    private void startAnimation(View rootView){
        //由于是使用了三种动画效果合在一起，所以要使用AnimationSet动画集
        AnimationSet set = new AnimationSet(false);
        RotateAnimation rtAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rtAnimation.setDuration(2000);
        rtAnimation.setFillAfter(true);

        ScaleAnimation scAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scAnimation.setDuration(2000);
        scAnimation.setFillAfter(true);

        AlphaAnimation alAnimation = new AlphaAnimation(0, 1);
        alAnimation.setDuration(2000);
        alAnimation.setFillAfter(true);

        set.addAnimation(rtAnimation);
        set.addAnimation(scAnimation);
        set.addAnimation(alAnimation);

        set.setAnimationListener(new Animation.AnimationListener() {
            //动画开始之前会执行方法体里面的事件
            @Override
            public void onAnimationStart(Animation arg0) {

            }
            //动画重复的过程中执行方法体里面的事件
            @Override
            public void onAnimationRepeat(Animation arg0) {

            }
            //动画执行完成会执行方法里面的事件
            @Override
            public void onAnimationEnd(Animation arg0) {
                startActivity(GuideActivity.class);
                finish();
            }
        });

        //执行动画
        rootView.startAnimation(set);
    }
}
