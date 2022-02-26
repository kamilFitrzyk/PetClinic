package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.petclinic.model.Pet;


public interface PetRepository extends CrudRepository<Pet, Long> {
}
