package springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
