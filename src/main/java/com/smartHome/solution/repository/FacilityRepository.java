package com.smartHome.solution.repository;

import com.smartHome.solution.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // Custom query methods, if needed
}

