package com.openclassrooms.entrevoisins.di;

import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.FavoriteDummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.FavoriteNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

/**
 * Dependency injector to get instance of services
 */
public class FDI {

    private static FavoriteNeighbourApiService service = new FavoriteDummyNeighbourApiService();

    /**
     * Get an instance on @{@link NeighbourApiService}
     * @return
     */public static FavoriteNeighbourApiService getNeighbourApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link NeighbourApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static NeighbourApiService getNewInstanceApiService() {
        return new DummyNeighbourApiService();
    }
}
