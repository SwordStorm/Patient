package com.gxwj.yimi.patient.ReservationBed.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.gugalor.citylist.CityList;
import com.gxwj.yimi.patient.R;

/**
 * 主页面之约床Fragment
 */
public class ReservationBedFragment extends Fragment {

    private Button bt_city;
    private Activity activity;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_reservation_bed, null);
        bt_city = (Button) view.findViewById(R.id.bt_city);

        return view;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CityList.class);
                startActivity(intent);
                /*Toast.makeText(getActivity(),"success",Toast.LENGTH_LONG).show();*/
            }
        });

    }
}
