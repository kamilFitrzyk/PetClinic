package springframework.petclinic.service;

import springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByIdLastName(String lastName);
}
