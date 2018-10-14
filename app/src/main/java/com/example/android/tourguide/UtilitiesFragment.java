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


public class UtilitiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.location_utilities_postal_services), getString(R.string.nairobi),
                getString(R.string.location_utilities_search_postal), R.drawable.utilities_post_office));
        locations.add(new Location(getString(R.string.location_utilities_banking_services), getString(R.string.nairobi),
                getString(R.string.location_utilities_search_banking), R.drawable.utilities_banks));
        locations.add(new Location(getString(R.string.location_utilities_sports_centers), getString(R.string.nairobi),
                getString(R.string.location_utilities_search_sports), R.drawable.utilities_sports));
        locations.add(new Location(getString(R.string.location_utilities_supermarkets), getString(R.string.nairobi), getString(R.string.location_utilities_search_sports), R.drawable.utilities_supermarket));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_utilities);

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


