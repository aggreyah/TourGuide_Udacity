package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HotelsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.location_hotels_intercontinental),
                getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_intercontinental));
        locations.add(new Location(getString(R.string.location_hotels_hilton), getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_hilton));
        locations.add(new Location(getString(R.string.location_hotels_sarova), getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_sarova));
        locations.add(new Location(getString(R.string.location_hotels_serena), getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_serena));
        locations.add(new Location(getString(R.string.location_hotels_ranalo), getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_ranalo));
        locations.add(new Location(getString(R.string.location_hotels_safari_park), getString(R.string.nairobi),
                getString(R.string.location_hotels_search), R.drawable.hotels_safari_park));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_hotels_and_restaurants);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location location = locations.get(position);
                String queryText = location.getDescriptionForMapSearch();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + queryText);
                Intent hotelsMapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                hotelsMapIntent.setPackage("com.google.android.apps.maps");
                startActivity(hotelsMapIntent);

            }
        });
        return rootView;
    }
}