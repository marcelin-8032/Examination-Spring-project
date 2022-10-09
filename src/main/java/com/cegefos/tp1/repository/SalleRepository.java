package com.cegefos.tp1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp1.entity.Salle;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer> {

}
