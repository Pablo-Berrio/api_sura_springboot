package com.example.proyectoSura.repositorios;

import com.example.proyectoSura.entidades.SignoVital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignoVitalRepositorio extends JpaRepository<SignoVital, Integer> {



}
