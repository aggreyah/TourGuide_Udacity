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


public class GameReservesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Samburu", "Samburu",
                "game reserves", R.drawable.game_reserves_samburu));
        locations.add(new Location("Amboseli", "Kajiado", "game reserves", R.drawable.game_reserves_amboseli));
        locations.add(new Location("Maasai mara", "Narok", "game reserves", R.drawable.game_reserves_maasai_mara));
        locations.add(new Location("Lake nakuru", "Nakuru", "game reserves", R.drawable.game_reserves_lake_nakuru));
        locations.add(new Location("Tsavo east", "Taita taveta", "game reserves", R.drawable.game_rserves_tsavo_east));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_game_reserves);

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

