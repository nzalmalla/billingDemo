package com.example.billing.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
@Id
    String id;
    String name;
    int age;
    String email;

}
