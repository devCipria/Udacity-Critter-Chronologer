package com.udacity.jdnd.course3.critter.user;

import javax.persistence.Column;
import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
public class CustomerDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    @Column(length = 1000)
    private String notes;
    private List<Long> petIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
