package com.example.lab2.repository;

import com.example.lab2.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCity(String name);

    Page<Location> findByCountryCode(String countryCode, Pageable pageable);
}

