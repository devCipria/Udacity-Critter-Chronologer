package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.schedule.ScheduleService;
import com.udacity.jdnd.course3.critter.user.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    private PetType petType;

    private String name;
    private LocalDate birthDate;

    @Column(length = 1000)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<Schedule> scheduleList;

    public void addScheduleToScheduleList(Schedule schedule) {
        if (scheduleList == null) {
            scheduleList = new ArrayList<>();
        }
        scheduleList.add(schedule);
    }

    // Constructors
    public Pet() {}

    public Pet(Long id, PetType petType, String name, LocalDate birthDate, String notes, Customer customer, List<Schedule> scheduleList) {
        this.id = id;
        this.petType = petType;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.customer = customer;
        this.scheduleList = scheduleList;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
