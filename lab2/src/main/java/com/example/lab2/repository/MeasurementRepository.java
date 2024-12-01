package com.example.lab2.repository;

import com.example.lab2.entity.Location;
import com.example.lab2.entity.Measurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@RepositoryRestResource
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Page<Measurement> findByDateGreaterThanEqualAndLocation(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date date,
            Location location,
            Pageable pageable
    );
    
}
