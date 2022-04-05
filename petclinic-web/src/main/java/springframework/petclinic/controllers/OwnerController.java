package springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springframework.petclinic.model.Owner;
import springframework.petclinic.service.OwnerService;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String findOwners(Owner owner, BindingResult result, Model model) {
        //allow parametric GET request for /owners to return all records
        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        //find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());
        if(results.isEmpty()) {
            //no owners found
            result.rejectValue("lastName","notFound","not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner find
            owner = results.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", result);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownersId}")
    public ModelAndView showOwner(@PathVariable("ownersId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/list")
    public String listOwners() {
        return "notimplemented";
    }


}
