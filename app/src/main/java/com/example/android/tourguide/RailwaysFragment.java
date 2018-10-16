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


public class RailwaysFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.location_railways_mombasa), getString(R.string.mombasa),
                getString(R.string.location_railways_search), R.drawable.railways_mombasa));
        locations.add(new Location(getString(R.string.location_railways_mtito_andei),
                getString(R.string.makueni), getString(R.string.location_railways_search),
                R.drawable.railways_mtito_andei));
        locations.add(new Location(getString(R.string.location_railways_nairobi),
                getString(R.string.nairobi), getString(R.string.location_railways_search),
                R.drawable.railways_nairobi));
        locations.add(new Location(getString(R.string.location_railways_voi),
                getString(R.string.voi), getString(R.string.location_railways_search),
                R.drawable.railways_voi));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_train_stations);

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

