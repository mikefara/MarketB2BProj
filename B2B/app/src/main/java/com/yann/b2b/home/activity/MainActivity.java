package com.yann.b2b.home.activity;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.yann.b2b.R;
import com.yann.b2b.base.BaseActivity;
import com.yann.b2b.home.HomeAdapter;
import com.yann.b2b.home.fragment.CenterFragment;
import com.yann.b2b.home.fragment.MarketingFragment;
import com.yann.b2b.home.fragment.MerchantFragment;
import com.yann.b2b.home.fragment.TaskFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    // UI
    private AHBottomNavigationViewPager viewPager;
    private AHBottomNavigation bottomNavigation;
    private AHBottomNavigationAdapter navigationAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    private boolean useMenuResource = true;
    private int[] tabColors;

    private List<Fragment> listfragment;

    /**
     * [初始化布局]
     *
     * @return 布局资源 ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

        bottomNavigation = $(R.id.bottom_navigation);
        viewPager = $(R.id.view_pager);

        if (useMenuResource) {
            tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
            navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_4);
            navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);
        } else {
            AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_apps_black_24dp, R.color.color_tab_1);
            AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_maps_local_bar, R.color.color_tab_2);
            AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_maps_local_restaurant, R.color.color_tab_3);
            AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_account_path, R.color.color_tab_4);

            bottomNavigationItems.add(item1);
            bottomNavigationItems.add(item2);
            bottomNavigationItems.add(item3);
            bottomNavigationItems.add(item4);

            bottomNavigation.addItems(bottomNavigationItems);
        }

        bottomNavigation.setTranslucentNavigationEnabled(true);
        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

    // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Set current item programmatically
        bottomNavigation.setCurrentItem(0);
        // Set listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Log.d("MainActivity","position:" + position + " / wasSelected"+wasSelected);
                if(!wasSelected){
                    viewPager.setCurrentItem(position);
                }
                return true;
            }
        });

        listfragment = new ArrayList<Fragment>(); //new一个List<Fragment>
        Fragment f1 = new TaskFragment();
        Fragment f2 = new MerchantFragment();
        Fragment f3 = new MarketingFragment();
        Fragment f4 = new CenterFragment();
        listfragment.add(f1);
        listfragment.add(f2);
        listfragment.add(f3);
        listfragment.add(f4);

        FragmentManager fm=getSupportFragmentManager();
        HomeAdapter mfpa=new HomeAdapter(fm, listfragment); //new myFragmentPagerAdater记得带上两个参数
        viewPager.setAdapter(mfpa);
        viewPager.setCurrentItem(0);
    }

//    private void showFragment(int index){
//        //创建修改实例
//        Fragment newFragment = new ();
//        FragmentTransaction transaction =getFragmentManager().beginTransaction();
//        // Replace whatever is in thefragment_container view with this fragment,
//        // and add the transaction to the backstack
//        transaction.replace(R.id.fragment_container,newFragment);
//        transaction.addToBackStack(null);
//        //提交修改
//        transaction.commit();
//    }


    /**
     * View点击
     *
     * @param v
     */
    @Override
    public void widgetClick(View v) {

    }
}
