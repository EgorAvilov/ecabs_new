package com.itechart.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BookingDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("passengerName")
    private String passengerName;

    @JsonProperty("passengerContactNumber")
    private String passengerContactNumber;

    @JsonProperty("pickupTime")
    private LocalDateTime pickupTime;

    @JsonProperty("asap")
    private Boolean asap;

    @JsonProperty("waitingTime")
    private LocalDateTime waitingTime;

    @JsonProperty("numberOfPassengers")
    private Integer numberOfPassengers;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("lastModifiedOn")
    private LocalDateTime lastModifiedOn;

    @JsonProperty("tripWaypoints")
    private List<TripWaypointDto> tripWaypoints;
}
