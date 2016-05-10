package com.gxwj.yimi.patient.Main.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gxwj.yimi.patient.HomePage.View.HomePageFragment;
import com.gxwj.yimi.patient.Main.Controller.FragmentTabAdapter;
import com.gxwj.yimi.patient.Message.View.MessageFragment;
import com.gxwj.yimi.patient.Mine.View.MineFragment;
import com.gxwj.yimi.patient.R;
import com.gxwj.yimi.patient.ReservationBed.View.ReservationBedFragment;

import java.util.List;

/**
 * 主页面之MainActivity
 */
public class MainActivity extends FragmentActivity {

    private List<Fragment> fragments;
    private RadioGroup mRadioGroup;
    private RadioButton tab_rb_a, tab_rb_b, tab_rb_c, tab_rb_d;
    private int tabIndex = 0;
    private FragmentTabAdapter tabAdapter;
    private FrameLayout mContent;

    static final int NUM_ITEMS = 4;//共4个fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 注意顺序
        setContentView(R.layout.activity_home); // 注意顺序
        this.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar); // 注意顺序
        //初始化
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.tab_content);

        /*HomePageFragment homePageFragment = new HomePageFragment();



        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tab_content,homePageFragment);
        fragmentTransaction.commit();
*/
        initView();
        initData();


    }


    private void initView() {
        mContent = (FrameLayout) findViewById(R.id.tab_content);
        mRadioGroup = (RadioGroup) findViewById(R.id.tabs_rg);
        tab_rb_a = (RadioButton) findViewById(R.id.tab_rb_a);
        tab_rb_b = (RadioButton) findViewById(R.id.tab_rb_b);
        tab_rb_c = (RadioButton) findViewById(R.id.tab_rb_c);
        tab_rb_d = (RadioButton) findViewById(R.id.tab_rb_d);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.tab_rb_a:
                        index = 0;
                        break;
                    case R.id.tab_rb_b:
                        index = 1;
                        break;
                    case R.id.tab_rb_c:
                        index = 2;
                        break;
                    case R.id.tab_rb_d:
                        index = 3;
                        break;
                }
                Fragment fragment = (Fragment) fragmentStatePagerAdapter.instantiateItem(mContent, index);
                fragmentStatePagerAdapter.setPrimaryItem(mContent, 0, fragment);
                fragmentStatePagerAdapter.finishUpdate(mContent);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mRadioGroup.check(R.id.tab_rb_a);
    }

    FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {


        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new HomePageFragment();
                    break;
                case 1:
                    fragment = new ReservationBedFragment();
                    break;
                case 2:
                    fragment = new MessageFragment();
                    break;
                case 3:
                    fragment = new MineFragment();
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    };

    private void initData() {


    }

}
