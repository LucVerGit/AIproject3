package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.OnClick;

public class NeighbourPage extends AppCompatActivity {

    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_page);
        mApiService = DI.getNeighbourApiService();

    }
    @OnClick(R.id.addfavorite)
    void addFavorite() {
       /// mApiService.addFavoriteNeighbour(neightbour neighbour);
        );


        finish();
    }
}