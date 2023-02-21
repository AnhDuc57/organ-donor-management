package edu.uef.entity;

import java.util.List;

public class Viscera {
    private int id;
    private String name;
    private OrganType type;
    private int quantity;
    private List<OrganDonor> organDonors;

    public Viscera() {
    }

    public Viscera(int id, String name, OrganType type, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganType getType() {
        return type;
    }

    public void setType(OrganType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrganDonor> getOrganDonors() {
        return organDonors;
    }

    public void setOrganDonors(List<OrganDonor> organDonors) {
        this.organDonors = organDonors;
    }

    @Override
    public String toString() {
        return "Viscera{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", quantity=" + quantity +
                '}';
    }
}
