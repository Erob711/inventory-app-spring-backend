package com.inventoryapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "item")
public class Item {

    @ManyToMany(mappedBy = "usersItems")
    private List<User> users;

    @Id
    @GeneratedValue
    private Integer id;


    @Size(min = 2, message = " Name of item must have minimum of 2 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @NotBlank(message = "Description cannot be blank")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Category cannot be blank")
    @Column(name = "category")
    private String category;

    @NotBlank(message = "Image cannot be blank")
    @Column(name = "image")
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
