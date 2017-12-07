package com.yann.b2b.welcome.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yann.b2b.R;
import com.yann.b2b.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yayun.xia on 2017/12/6.
 */

@SuppressLint("Registered")
public class GuideActivity extends BaseActivity {

    private ViewPager vpGuide;
    private LinearLayout llGuide;
    private int currIndex = -1;

    private static int[] imagesId = new int[] { R.drawable.guide1,
            R.drawable.guide2, R.drawable.guide3 };

    private List<ImageView> imageViewList;

    /**
     * [初始化布局]
     *
     * @return 布局资源 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
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
        vpGuide = $(R.id.vp_guide);
        llGuide = $(R.id.ll_guide);
    }

    /**
     * [初始化数据： 在基础数据初始化完成之后可以使用该方法]
     */
    @Override
    protected void initData() {
        super.initData();
        imageViewList = new ArrayList<ImageView>();
        MyLayoutParams layoutParams = new MyLayoutParams(10, 10);

        for (int i = 0; i < imagesId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imagesId[i]);
            imageViewList.add(imageView);
        }

        for (int i = 0; i < imagesId.length; i++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.guide_point_shape);
            if (i > 0) {
                layoutParams.leftMargin = 10;
            }
            view.setLayoutParams(layoutParams);

            llGuide.addView(view);
        }

        vpGuide.setAdapter(new myGuideAdapter());

        currIndex = 0;
        vpGuide.setCurrentItem(currIndex);
        llGuide.getChildAt(0)
                .setBackgroundResource(R.drawable.move_point_shape);
        vpGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    case 0:
                        llGuide.getChildAt(0).setBackgroundResource(
                                R.drawable.move_point_shape);
                        llGuide.getChildAt(1).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        llGuide.getChildAt(2).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        break;
                    case 1:
                        llGuide.getChildAt(0).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        llGuide.getChildAt(1).setBackgroundResource(
                                R.drawable.move_point_shape);
                        llGuide.getChildAt(2).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        break;
                    case 2:
                        llGuide.getChildAt(0).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        llGuide.getChildAt(1).setBackgroundResource(
                                R.drawable.guide_point_shape);
                        llGuide.getChildAt(2).setBackgroundResource(
                                R.drawable.move_point_shape);

                        break;

                    default:
                        break;
                }
                currIndex = arg0;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * View点击
     *
     * @param v
     */
    @Override
    public void widgetClick(View v) {

    }

    class MyLayoutParams extends android.widget.LinearLayout.LayoutParams {

        public MyLayoutParams(int arg0, int arg1) {
            super(arg0, arg1);
        }
    }

    private class myGuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {

            return imagesId.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewGroup) container).addView(imageViewList.get(position));
            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewGroup) container).removeView((View) object);
        }

    }
}
