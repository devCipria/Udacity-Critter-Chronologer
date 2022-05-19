package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private CustomerRepository customerRepository;

//    https://knowledge.udacity.com/questions/430058
    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {

        Customer customer = customerRepository.getOne(petDTO.getOwnerId());

        Pet petToSave = convertPetDTOToEntity(petDTO);
        petToSave.setCustomer(customer);

        Pet savedPet = petService.save(petToSave);

        return  convertEntityToPetDTO(savedPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return convertEntityToPetDTO(petService.findPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<Pet> petList = petService.findAllPets();
        List<PetDTO> petDTOList = new ArrayList<>();

        for (Pet p : petList) {
            petDTOList.add(convertEntityToPetDTO(p));
        }

        return petDTOList;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> petList = petService.findPetsByOwner(ownerId);
        List<PetDTO> petDTOList = new ArrayList<>();

        for (Pet p : petList) {
            petDTOList.add(convertEntityToPetDTO(p));
        }
        return petDTOList;
    }

    private PetDTO convertEntityToPetDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        petDTO.setOwnerId(pet.getCustomer().getId());
        return petDTO;
    }

    private Pet convertPetDTOToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        return pet;
    }
}
