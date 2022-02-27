package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
