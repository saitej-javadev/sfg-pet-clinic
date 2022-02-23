package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframwork.sfgpetclinic.model.Owner;
import guru.springframwork.sfgpetclinic.model.Vet;
import guru.springframwork.sfgpetclinic.services.OwnerService;
import guru.springframwork.sfgpetclinic.services.VetService;
import guru.springframwork.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframwork.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");

        ownerService.save(owner1);

        System.out.println("Loaded Owners............");


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner1.setFirstname("Fiona");
        owner1.setLastname("Glenee");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        vetService.save(vet2);

        System.out.println("Loaded Vets..................");



    }
}
