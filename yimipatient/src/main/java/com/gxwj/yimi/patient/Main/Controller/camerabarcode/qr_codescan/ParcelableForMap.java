package com.gxwj.yimi.patient.Main.Controller.camerabarcode.qr_codescan;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;


public class ParcelableForMap implements Parcelable {

    private static Map<String, String> map = new HashMap<String, String>();

    public ParcelableForMap(Map<String, String> map) {
        this.map = map;
    }

    public ParcelableForMap(Parcel parcel) {
        this.map = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(map);
    }

    public static final Creator<ParcelableForMap> CREATOR = new Creator<ParcelableForMap>() {

        @Override
        public ParcelableForMap createFromParcel(Parcel source) {
            return new ParcelableForMap(source.readHashMap(HashMap.class.getClassLoader()));
        }

        @Override
        public ParcelableForMap[] newArray(int size) {
            return new ParcelableForMap[size];
        }

    };

}
