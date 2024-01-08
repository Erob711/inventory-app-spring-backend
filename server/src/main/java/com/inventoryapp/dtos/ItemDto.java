package com.inventoryapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.Data;

@Data
public class ItemDto {
    private Integer id;

    @Size(min=2, message=" Name of item must have minimum of 2 characters")
    private String name;
    private double price;
    @NotBlank(message="Description cannot be blank")
    private String description;

    @NotBlank(message="Category cannot be blank")
    private String category;
    @NotBlank(message="Image cannot be blank")
    private String image;

    public ItemDto() {
    }

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
