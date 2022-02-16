package springframework.petclinic.service;

import springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByIdLastName(String lastName);
    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
