package springframework.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.petclinic.model.Owner;



public interface OwnerRepository extends CrudRepository<Owner, Long> {


    Owner findByLastName(String lastName);

}
