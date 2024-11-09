package com.uco.backend.api.trasformate.domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String  lastname;
    private String nameUser;
    private String password;
    private Document document;
    private UserType userType;
    private String address;
    private String phone;
    private Routine routine;
    private LocalDateTime created;
}
