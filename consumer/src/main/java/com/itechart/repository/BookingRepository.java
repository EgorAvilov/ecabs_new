package com.itechart.repository;


import com.itechart.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

   // Booking deleteBookingById(Long id);
}
