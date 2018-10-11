package com.example.android.tourguide;

public class Location {

    // Name of location
    private String mLocationName;

    //City of the location
    private String mCityLocated;

    // An image associated with the location
    private int mImageResourceId;

    // Description of location
    private String mDescriptionForMapSearch;

    /**
     * Location object constructor
     */
    public Location(String locationName, String cityLocated, String mapSearchWord, int imageResourceId) {
        mLocationName = locationName;
        mCityLocated = cityLocated;
        mImageResourceId = imageResourceId;
        mDescriptionForMapSearch = mapSearchWord;
    }

    /**
     * Get location name.
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     * Get city of the location object.
     */
    public String getCityLocated() {
        return mCityLocated;
    }

    /**
     * Get image of the location.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * get location description for map search
     **/
    public String getDescriptionForMapSearch() {
        return mDescriptionForMapSearch;
    }
}
