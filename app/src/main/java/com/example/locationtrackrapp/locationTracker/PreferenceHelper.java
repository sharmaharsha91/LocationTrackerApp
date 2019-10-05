package com.example.locationtrackrapp.locationTracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class PreferenceHelper {

    private SharedPreferences sharedPreferences;
    private Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    public PreferenceHelper(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mEditor = sharedPreferences.edit();
    }


    public List<LocationWrapper> getSharedPreferenceStringList() {
        int size = sharedPreferences.getInt("latitude" + "size", 0);
        List<LocationWrapper> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            LocationWrapper locationWrapper = new LocationWrapper();
            locationWrapper.setAddress(sharedPreferences.getString("address" + i, ""));
            locationWrapper.setLatitude(sharedPreferences.getString("latitude" + i, ""));
            locationWrapper.setLongitude(sharedPreferences.getString("longitude" + i, ""));
            list.add(locationWrapper);
        }
        return list;
    }

    public void setSharedPreferenceStringList(String pLatitude,List<LocationWrapper> pData) {
        mEditor.putInt(pLatitude + "size", pData.size());
        mEditor.commit();

        for (int i = 0; i < pData.size(); i++) {
            if (pData.get(i).getLatitude() != null) {
                mEditor.putString(pLatitude + i, (pData.get(i).getLatitude() + "").toLowerCase());
            }
            if (pData.get(i).getLongitude() != null) {
                mEditor.putString("longitude" + i, (pData.get(i).getLongitude() + "").toLowerCase());
            }

            if (pData.get(i).getAddress() != null) {
                mEditor.putString("address" + i, (pData.get(i).getAddress() + "").toLowerCase());
            }
                mEditor.commit();
            }
        }



}
