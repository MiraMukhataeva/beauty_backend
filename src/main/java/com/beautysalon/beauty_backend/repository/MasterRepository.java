package com.beautysalon.beauty_backend.repository;

import com.beautysalon.beauty_backend.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MasterRepository extends JpaRepository<Master, UUID> {
    List<Master> findAllByNameSurname(String nameSurname);
    List<Master> findAllByExperienceBetween(int experienceFrom, int experienceTo);
}
