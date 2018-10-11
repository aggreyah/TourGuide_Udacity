package com.example.android.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    private int mColorId;

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorId) {
        super(context, 0, locations);
        mColorId = colorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_item, parent, false);

            View locationDetailsViewGroup = listItemView.findViewById(R.id.location_details_group);
            int color = ContextCompat.getColor(getContext(), mColorId);
            locationDetailsViewGroup.setBackgroundColor(color);
        }

        Location currentLocation = getItem(position);

        TextView locationNameView = listItemView.findViewById(R.id.location_name);
        locationNameView.setText(currentLocation.getLocationName());

        TextView cityLocatedView = listItemView.findViewById(R.id.city_located);
        cityLocatedView.setText(currentLocation.getCityLocated());

        ImageView locationImageView = listItemView.findViewById(R.id.location_image);
        locationImageView.setImageResource(currentLocation.getImageResourceId());

        return listItemView;
    }
}
