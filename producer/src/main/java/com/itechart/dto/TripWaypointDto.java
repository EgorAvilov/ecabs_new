package com.itechart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TripWaypointDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("locality")
    private String locality;

    @JsonProperty("latitude")
    private Float latitude;

    @JsonProperty("longitude")
    private Float longitude;
}
