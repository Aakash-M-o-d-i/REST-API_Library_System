package com.LMS.LibraryManagementSys;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @Id // id for knowing in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database column setter
    private Long id;
    private String name;
}
