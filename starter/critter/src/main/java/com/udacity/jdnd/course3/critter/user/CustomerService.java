package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

//    public Customer findCustomerByPetId(Long petId) {
//        return customerRepository.findCustomerByPetId(petId);
//    }

//    public Customer findCustomerByPet(long petId) {
//        return customerRepository.
//    }




}
