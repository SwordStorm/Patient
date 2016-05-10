package com.gxwj.yimi.patient.HomePage.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.gxwj.yimi.patient.R;

/**
 * 主页面布局之HomePageFragment
 */
public class HomePageFragment extends Fragment {

    private GridView gridView;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_page, null);
        gridView = (GridView) view.findViewById(R.id.gridView_pattern);
        imageView = (ImageView) view.findViewById(R.id.itemImage);

        ArrayList<HashMap<String, Object>> lsImageItem = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("ItemImage", R.drawable.ic_item1_home);
        map.put("ItemText", getResources().getString(R.string.item1_home));
        lsImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.ic_item2_home);
        map.put("ItemText", getResources().getString(R.string.item2_home));
        lsImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.ic_item3_home);
        map.put("ItemText", getResources().getString(R.string.item3_home));
        lsImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.ic_item4_home);
        map.put("ItemText", getResources().getString(R.string.item4_home));
        lsImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.ic_item5_home);
        map.put("ItemText", getResources().getString(R.string.item5_home));
        lsImageItem.add(map);

        map = new HashMap<String, Object>();
        map.put("ItemImage", R.drawable.ic_item6_home);
        map.put("ItemText", getResources().getString(R.string.item6_home));
        lsImageItem.add(map);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
                lsImageItem,
                R.layout.item_homepage,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.itemImage, R.id.itemText});

        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new ItemClickListener());

        Log.i("", "onCreateView();");

        return view;
    }

    /**
     * 首页菜单按钮的Item点击处理事件
     */
    // 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);

            getActivity().setTitle((String) item.get("ItemText"));

            switch (position) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:


            }

        }
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }


}
