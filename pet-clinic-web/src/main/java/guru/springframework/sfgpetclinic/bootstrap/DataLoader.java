package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


   /* public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }*/


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);


        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgury = new Speciality();
        surgury.setDescription("Surgury");
        Speciality savedSurgury = specialityService.save(surgury);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
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
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenee");
        owner2.setAddress("123 Ann street");
        owner2.setCity("Mimai");
        owner2.setTelephone("34334333");


        Pet fionasCat = new Pet();
        fionasCat.setId(1L);
        fionasCat.setPetType(savedDogPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        owner1.getPets().add(fionasCat);


        ownerService.save(owner2);


        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");
        visitService.save(catVisit);


        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Bob");
        vet2.setLastName("Marley");
        vet2.getSpecialities().add(savedSurgury);

        vetService.save(vet2);

        System.out.println("Loaded Vets..................");


    }
}
