package springframework.petclinic.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springframework.petclinic.model.Owner;

import java.util.List;
import java.util.Set;

@Repository
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByIdLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
