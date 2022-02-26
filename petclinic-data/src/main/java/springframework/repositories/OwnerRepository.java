package springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {


}
