package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public interface FavoriteNeighbourApiService {


    List<Neighbour> getFavoriteNeighbours();


    void deleteFavoriteNeighbour(Neighbour neighbour);


    void createFavoriteNeighbour(Neighbour neighbour);
}
