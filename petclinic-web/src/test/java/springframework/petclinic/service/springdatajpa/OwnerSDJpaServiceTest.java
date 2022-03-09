package springframework.petclinic.service.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.petclinic.model.Owner;
import springframework.petclinic.repositories.OwnerRepository;
import springframework.petclinic.repositories.PetRepository;
import springframework.petclinic.repositories.PetTypeRepository;
import springframework.petclinic.service.map.OwnerMapService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        Mockito.when(service.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {

        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);

    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnOwner);

        Owner saveOwner = service.save(ownerToSave);

        assertNotNull(saveOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        Mockito.verify(ownerRepository,Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }

    @Test
    void findByIdLastName() {
        Mockito.when(service.findByIdLastName(Mockito.any())).thenReturn(returnOwner);

        Owner smith = service.findByIdLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }
}