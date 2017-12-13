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

public class TaskFragment extends BaseFrament {
    //三个一般必须重载的方法
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println("TaskFragment--onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        System.out.println("TaskFragment--onCreateView");
        return inflater.inflate(R.layout.fragment_task, container, false);

    }

    @Override
    public void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
        System.out.println("TaskFragment--onPause");
    }



    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
        System.out.println("TaskFragment--onResume");
    }

    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
        super.onStop();
        System.out.println("TaskFragment--onStop");
    }
}
