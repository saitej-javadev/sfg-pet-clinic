package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

   private final  OwnerService ownerService;
   private final   VetService vetService;
   private final PetTypeService petTypeService;

   /* public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog  = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);


        PetType cat  = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        owner1.setAddress("123 Ann street");
        owner1.setCity("Mimai");
        owner1.setTelephone("34334333");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);



        ownerService.save(owner1);

        System.out.println("Loaded Owners............");


        Owner owner2 = new Owner();

        owner2.setFirstname("Fiona");
        owner2.setLastname("Glenee");
        owner2.setAddress("123 Ann street");
        owner2.setCity("Mimai");
        owner2.setTelephone("34334333");


        Pet fionasCat= new Pet();
        fionasCat.setPetType(savedDogPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        owner1.getPets().add(fionasCat);


        ownerService.save(owner2);

        Vet vet1 = new Vet();

        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstname("Bob");
        vet2.setLastname("Marley");

        vetService.save(vet2);

        System.out.println("Loaded Vets..................");



    }
}
