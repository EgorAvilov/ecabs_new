package com.itechart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("userpic")
    private String userpic;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("lastVisit")
    private LocalDateTime lastVisit;
}
