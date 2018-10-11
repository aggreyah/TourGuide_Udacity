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
        locations.add(new Location("Mombasa terminus", "Mombasa",
                "railways", R.drawable.railways_mombasa));
        locations.add(new Location("Mtito andei terminus", "Makueni", "railways", R.drawable.railways_mtito_andei));
        locations.add(new Location("Nairobi terminus", "Nairobi", "railways", R.drawable.railways_nairobi));
        locations.add(new Location("Voi terminus", "Voi", "railways", R.drawable.railways_voi));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_train_stations);

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

