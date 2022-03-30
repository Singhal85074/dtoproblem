package com.example.demodtoonetomany.repository;

import com.example.demodtoonetomany.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
