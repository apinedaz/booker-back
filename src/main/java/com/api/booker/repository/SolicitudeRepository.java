package com.api.booker.repository;

import com.api.booker.models.entity.SolicitudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudeRepository extends JpaRepository<SolicitudeEntity,Integer> {

    SolicitudeEntity save(SolicitudeEntity solicitude);

    List<SolicitudeEntity> findByState(String state);

    List<SolicitudeEntity> findByIdUser(int id_user);

}
