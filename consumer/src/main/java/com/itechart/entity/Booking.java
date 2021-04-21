package com.itechart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "contact_number")
    private String passengerContactNumber;

    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    @Column(name = "asap")
    private Boolean asap;

    @Column(name = "waiting_time")
    private LocalDateTime waitingTime;

    @Column(name = "number_of_passengers")
    private Integer numberOfPassengers;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime LastModifiedOn;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TripWaypoint> tripWaypoints;
}
