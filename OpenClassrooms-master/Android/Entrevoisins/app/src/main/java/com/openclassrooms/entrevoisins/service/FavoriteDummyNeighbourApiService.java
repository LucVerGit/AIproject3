package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy favorite
 */
public class FavoriteDummyNeighbourApiService implements  FavoriteNeighbourApiService {

    private List<Neighbour> neighbours = FavoriteDummyNeighbourGenerator.generateNeighbours();



    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        return neighbours;
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) { neighbours.remove(neighbour);}

    @Override
    public void createFavoriteNeighbour(Neighbour neighbour) {neighbours.add(neighbour); }
}
