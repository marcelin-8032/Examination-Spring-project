package com.cegefos.tp2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp2.entity.Salle;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer> {

}
