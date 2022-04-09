package springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.petclinic.model.Owner;
import springframework.petclinic.model.PetType;
import springframework.petclinic.service.OwnerService;
import springframework.petclinic.service.PetService;
import springframework.petclinic.service.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petsService;
    private final OwnerService ownersService;
    private final PetTypeService petTypeService;

    public PetController(PetService pets, OwnerService owners, PetTypeService petTypeService) {
        this.petsService = pets;
        this.ownersService = owners;
        this.petTypeService = petTypeService;
    }


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownersService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
