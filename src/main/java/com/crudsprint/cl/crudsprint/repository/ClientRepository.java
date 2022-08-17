package com.crudsprint.cl.crudsprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crudsprint.cl.crudsprint.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select c from Client c where c.rut = ?1")
    List<Client> findByRut(String rut);
}