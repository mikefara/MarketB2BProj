package com.yann.b2b.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yann.b2b.R;
import com.yann.b2b.base.BaseFrament;

/**
 * Created by xyy on 2017/12/12.
 */

public class CenterFragment extends BaseFrament {
    //三个一般必须重载的方法
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println("CenterFragment--onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        System.out.println("CenterFragment--onCreateView");
        return inflater.inflate(R.layout.fragment_center, container, false);

    }

    @Override
    public void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
        System.out.println("CenterFragment--onPause");
    }



    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
        System.out.println("CenterFragment--onResume");
    }

    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
        super.onStop();
        System.out.println("CenterFragment--onStop");
    }
}
