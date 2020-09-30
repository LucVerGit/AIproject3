package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favneighbours= new ArrayList<>();


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
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        if (!favneighbours.contains(neighbour)) {
            favneighbours.add(neighbour);
        }
    }


    @Override
    public List<Neighbour> getFavoriteNeighbour()
    {
        return favneighbours;
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
            favneighbours.remove(neighbour);
        }
    }

