package de.capstone.backend.service;

import de.capstone.backend.model.Scale;
import de.capstone.backend.model.Species;
import de.capstone.backend.repo.PlantSpeciesRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class PlantSpeciesServiceTest {

    private final Scale scale = new Scale(4);

    private final PlantSpeciesRepo plantSpeciesRepo = mock(PlantSpeciesRepo.class);
    private final IdService idService = mock(IdService.class);

    @Test
    void should_Return_PlantSpecies_List() {
        //GIVEN
        Species species = new Species("1","Ficus", scale,scale);
        Species species1 = new Species("2","Monstera", scale,scale);
        Species species2 = new Species("3","Palm", scale,scale);
        when(plantSpeciesRepo.findAll()).thenReturn(
                List.of(
                        species,
                        species1,
                        species2
                )
        );
        PlantSpeciesService plantSpeciesService = new PlantSpeciesService(plantSpeciesRepo,idService);
        //WHEN
        List<Species> actual = plantSpeciesService.list();

        //THEN
        assertThat(actual, containsInAnyOrder(
                species2,
                species1,
                species
        ));
    }

    @Test
    void should_Return_Species_By_Id() {
        //GIVEN
        Species species = new Species("1","Ficus", scale,scale);
        when(plantSpeciesRepo.findById("1")).thenReturn(Optional.of(species));
        PlantSpeciesService plantSpeciesService = new PlantSpeciesService(plantSpeciesRepo,idService);


        //WHEN
        Species result = plantSpeciesService.findById("1");

        //THEN
        assertThat(result, is(species));
    }

    @Test
    void should_Add_Species() {
        //GIVEN
        Species speciesToAdd = new Species("4","Cactus",scale,scale);
        when(plantSpeciesRepo.save(speciesToAdd)).thenReturn(speciesToAdd);
        PlantSpeciesService plantSpeciesService = new PlantSpeciesService(plantSpeciesRepo, idService);
        //WHEN
        Species result = plantSpeciesService.addSpecies(speciesToAdd);
        //THEN
        assertThat(result, is(speciesToAdd));
        verify(plantSpeciesRepo).save(speciesToAdd);
    }

    @Test
    void search_Should_Return_Species() {
        //GIVEN
        Species species;
        when(plantSpeciesRepo.findAll()).thenReturn(
                List.of(
                        new Species("1","Ficus", scale,scale),
                        species = new Species("2","Monstera", scale,scale),
                        new Species("3","Palm", scale,scale)
                )
        );
        PlantSpeciesService plantSpeciesService = new PlantSpeciesService(plantSpeciesRepo, idService);
        //WHEN
        List<Species> actual = plantSpeciesService.search("Mon");
        //THEN
        assertThat(actual, containsInAnyOrder(
                species

        ));

    }

    @Test
    void should_Delete_By_Id() {
        //GIVEN
        Species species = new Species("1","Ficus", scale,scale);
        when(plantSpeciesRepo.findById("1")).thenReturn(Optional.of(species));
        PlantSpeciesService plantSpeciesService = new PlantSpeciesService(plantSpeciesRepo,idService);
        //WHEN
        plantSpeciesService.delete("1");
        //THEN
        verify(plantSpeciesRepo).delete(species);

    }
}