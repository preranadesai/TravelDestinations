package com.example.traveldestinations.model;

import android.util.Log;

/**
 * Created by prerana on 2/23/2016.
 */
public class Destination {
    private String mName;
    private String mCountry;
    private String mUrl;
    private String mDescription;

    //Used as constants to pass in Intent
    public static final String ID_DESCRIPTION = "description";
    public static final String ID_IMAGEURL = "imageUrl";

    public Destination(String name, String country, String url, String desc){
        mName = name;
        mCountry = country;
        mUrl = url;
        mDescription = desc;
    }

    public String getDisplayName() {
        StringBuilder builder = new StringBuilder();
        builder.append(mName);
        builder.append(", ");
        builder.append(mCountry);
        Log.i("Dest", builder.toString());
        return builder.toString();
    }

    public String getDescription() {
        return mDescription;
    }

    public String getUrl() {
        return mUrl;
    }
}
