package springframework.petclinic.bootstrap;

import springframework.petclinic.service.OwnerService;
import springframework.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    //private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
