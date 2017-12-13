package com.yann.b2b.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xyy on 2017/12/12.
 */

public class HomeAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<Fragment> listfragment; //创建一个List<Fragment>
    public HomeAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragmetnmanager = fm;
        this.listfragment = list;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}
