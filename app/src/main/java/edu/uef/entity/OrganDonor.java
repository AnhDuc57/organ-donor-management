package edu.uef.entity;

import java.util.Date;
import java.util.List;

public class OrganDonor extends Person{
    private List<Viscera> visceras;

    public OrganDonor(int id, String firstName, String lastName, int gender, Date birthday, String address, String phoneNumber, String email) {
        super(id, firstName, lastName, gender, birthday, address, phoneNumber, email);
    }
    public OrganDonor() {

    }
    public List<Viscera> getVisceras() {

        return visceras;
    }

    public void setVisceras(List<Viscera> visceras) {

        this.visceras = visceras;
    }
}
