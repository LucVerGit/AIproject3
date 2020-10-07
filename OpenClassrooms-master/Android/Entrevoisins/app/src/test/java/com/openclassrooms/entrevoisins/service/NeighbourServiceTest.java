package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }


    @Test
    public void getFavoriteNeighbour (){
        List<Neighbour> mFavoriteNeighbour = service.getFavoriteNeighbour();
        List<Neighbour> expectedmFavoriteNeighbour = service.getFavoriteNeighbour();
        assertThat(mFavoriteNeighbour, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedmFavoriteNeighbour.toArray()));
    }

    @Test
    public void addFavoriteNeighbour (){
        Neighbour neighbour = new Neighbour(1, "Caroline", "https://i.pravatar.cc/350?u=a042581f4e29026704d", "lyon ; 5km",
                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..");
        service.addFavoriteNeighbour(neighbour);
        assertEquals(1, service.getFavoriteNeighbour().size());
    }

    @Test
    public void deleteFavoriteNeighbour (){
        Neighbour neighbour = new Neighbour(1, "Caroline", "https://i.pravatar.cc/350?u=a042581f4e29026704d", "lyon ; 5km",
                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..");
        service.addFavoriteNeighbour(neighbour);
        Neighbour neighbourFavToDelete = service.getFavoriteNeighbour().get(0);
        service.deleteFavoriteNeighbour(neighbourFavToDelete);
        assertFalse(service.getFavoriteNeighbour().contains(neighbourFavToDelete));
    }


}
