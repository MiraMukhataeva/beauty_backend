package com.beautysalon.beauty_backend.repository;

import com.beautysalon.beauty_backend.entity.BeautyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BeautyServiceRepository extends JpaRepository<BeautyService, UUID> {
    List<BeautyService> findAllByName(String name);
    List<BeautyService> findAllByType(String type);
    List<BeautyService> findAllByPrice(int price);
}
