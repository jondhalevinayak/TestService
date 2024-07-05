package com.testSevice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    public Integer user_id;

    public String name;

    public int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    public Set<Address> addresses;

}
