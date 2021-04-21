package com.itechart.dto;

import lombok.Data;


import java.time.LocalDateTime;

@Data

public class User {

    private String id;

    private String name;

    private String userpic;

    private String email;

    private String gender;

    private String locale;

    private LocalDateTime lastVisit;
}
