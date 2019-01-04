package com.automata.betgenius;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentStandings extends Fragment {
    WebView webView;
    SwipeRefreshLayout refresher;


    View v;
    String[] leagues = {"Barclays Premier League", "Spanish La Liga", "German Bundesliga", "French Ligue 1", "Italian Serie A"
            , "MLS", "UEFA Champions League", "UEFA Europa League", "England Championship", "England Ligue 1",
            "England Ligue 2", "Belgium Jupiler League", "Brazil Serie A", "Holland Eredivisie", "Portugal Primeira Liga", "Turkish Super Lig"};

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_h2h, container, false);

        listView = (ListView) v.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, leagues);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Detailed.class);
                intent.putExtra("title",listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });



        return v;
    }



}
