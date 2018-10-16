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


public class AirportsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.location_airports_jkia), getString(R.string.nairobi),
                getString(R.string.location_airports_search), R.drawable.airports_jkia));
        locations.add(new Location(getString(R.string.location_airports_moi), getString(R.string.mombasa),
                getString(R.string.location_airports_search), R.drawable.airports_moi_international));
        locations.add(new Location(getString(R.string.location_airports_kisumu), getString(R.string.kisumu),
                getString(R.string.location_airports_search), R.drawable.airports_kisumu));
        locations.add(new Location(getString(R.string.location_airports_wilson), getString(R.string.nairobi),
                getString(R.string.location_airports_search), R.drawable.airports_wilson));
        locations.add(new Location(getString(R.string.location_airports_eldoret), getString(R.string.eldoret),
                getString((R.string.location_airports_search)), R.drawable.airports_eldoret));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_airports);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Location location = locations.get(position);
                String queryText = location.getDescriptionForMapSearch();
                Uri tourGuideMapIntentUri = Uri.parse(getString(R.string.uri_parse) + queryText);
                Intent hotelsMapIntent = new Intent(Intent.ACTION_VIEW, tourGuideMapIntentUri);
                hotelsMapIntent.setPackage(getString(R.string.map_intent_set_package));
                startActivity(hotelsMapIntent);

            }
        });
        return rootView;
    }
}

