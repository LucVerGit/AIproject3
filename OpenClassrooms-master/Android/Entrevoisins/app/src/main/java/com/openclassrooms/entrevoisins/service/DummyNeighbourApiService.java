package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    public List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {

        neighbours.get( neighbours.indexOf(neighbour)).setFavorite(true);

    }


    @Override
    public List<Neighbour> getFavoriteNeighbour() {
        List<Neighbour> favneighbours = new ArrayList<>();

        for (Neighbour n : neighbours
        ) {

        if (n.isFavorite())
        {
            favneighbours.add(n);
        }
        }

        return favneighbours;
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        neighbours.get( neighbours.indexOf(neighbour)).setFavorite(false);
    }
}

