package com.inventoryapp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_table")
public class User {



    @JoinTable(name="user_table_item",
    joinColumns = @JoinColumn(name="item_id"),
    inverseJoinColumns = @JoinColumn(name="user_table_id"))
    @ManyToMany
    private List<Item> usersItems;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
