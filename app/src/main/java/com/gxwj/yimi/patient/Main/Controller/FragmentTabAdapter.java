package com.gxwj.yimi.patient.Main.Controller;

import android.app.Fragment;
import android.widget.RadioGroup;

import java.util.List;

import com.gxwj.yimi.patient.Main.View.MainActivity;

/**
 * Created by SwordStorm on 2016/4/26.
 *
 * APP主Activity的子Fragment选择的单选框适配器
 */
public class FragmentTabAdapter implements RadioGroup.OnCheckedChangeListener {

    private final List<Fragment> fragments;
    private final RadioGroup rgs;
    private final MainActivity mainactivity;
    private final int fragmentContentId;
    private Fragment subfragment;
    private int currentTab = 0;

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        for (int i = 0; i < rgs.getChildCount(); i++) {
            if (rgs.getChildAt(i).getId() == checkedId) {
                try {
                    subfragment = getCurrentFragment().getFragmentManager().findFragmentByTag("Tag" + i);
                } catch (Exception e) {
                    subfragment = null;
                }

                if (subfragment == null) {
                    subfragment = this.fragments.get(i);
                }

                if(!subfragment.isAdded()){
                    this.mainactivity.getFragmentManager().beginTransaction().add(fragmentContentId,this.fragments.get(i),"Tag"+i).commit();
                }else{
                    this.mainactivity.getFragmentManager().beginTransaction().show(subfragment).commit();
                }

                showTabSelection(i); //显示目标Tabfragment



            }
        }
    }

    /**
     * 切换Tabfragment
     */
    private void showTabSelection(int idx) {

        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = this.mainactivity.getFragmentManager().findFragmentByTag("Tag" + i);
            if (fragment == null) {
                fragment = fragments.get(i);
            }

            if (idx == i) {
                this.mainactivity.getFragmentManager().beginTransaction().show(fragment).commit();
            } else {
                this.mainactivity.getFragmentManager().beginTransaction().hide(fragment).commit();
            }
        }

        currentTab = idx;

    }

    /**
     *
     * @param activity
     * @param fragments
     * @param fragmentContentId
     * @param rgs
     * @param index
     */
    public FragmentTabAdapter(MainActivity activity, List<Fragment> fragments,
                              int fragmentContentId, RadioGroup rgs, int index) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.mainactivity = activity;
        this.fragmentContentId = fragmentContentId;

        subfragment = this.mainactivity.getFragmentManager().findFragmentByTag("Tag" + index);
        if (subfragment == null) {
            subfragment = this.fragments.get(index);
        }

        if (subfragment.isAdded()) {
            this.mainactivity.getFragmentManager().beginTransaction().add(fragmentContentId, (Fragment) this.fragments.get(index), "Tag" + index).commit();
        } else {
            this.mainactivity.getFragmentManager().beginTransaction().show(subfragment).commit();
        }

        rgs.setOnCheckedChangeListener(this);

    }

    /**
     * 返回当前选中标签页的id
     */
    public int getCurrentTab() {
        return currentTab;
    }

    /**
     * 返回当前选中标签页Fragment
     */
    public Fragment getCurrentFragment() {

        Fragment fragment = mainactivity.getFragmentManager().findFragmentByTag("Tag" + currentTab);
        if (fragment == null) {
            fragment = fragments.get(currentTab);
        }
        return fragment;
    }

}
