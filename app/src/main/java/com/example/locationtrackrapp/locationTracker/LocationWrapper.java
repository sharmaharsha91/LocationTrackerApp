package com.example.locationtrackrapp.locationTracker;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationWrapper implements Parcelable{



    public LocationWrapper() {

    }

    protected LocationWrapper(Parcel in) {
        latitude = in.readString();
        longitude = in.readString();
        address = in.readString();
    }

    public static final Creator<LocationWrapper> CREATOR = new Creator<LocationWrapper>() {
        @Override
        public LocationWrapper createFromParcel(Parcel in) {
            return new LocationWrapper(in);
        }

        @Override
        public LocationWrapper[] newArray(int size) {
            return new LocationWrapper[size];
        }
    };

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String latitude;
    private String longitude;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(address);
    }


}
