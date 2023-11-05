package com.example.proyectoSura.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombresExamen", length = 50, nullable = false)
    private String nombreExamen;
    @Column(name = "fechaExamen", nullable = false)
    private LocalDate fechaeExamen;
    @Column(name = "imagenExamen", length = 80, nullable = false)
    private String imagenExamen;

    public Examen() {
    }

    public Examen(Integer id, String nombreExamen, LocalDate fechaeExamen, String imagenExamen) {
        this.id = id;
        this.nombreExamen = nombreExamen;
        this.fechaeExamen = fechaeExamen;
        this.imagenExamen = imagenExamen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public LocalDate getFechaeExamen() {
        return fechaeExamen;
    }

    public void setFechaeExamen(LocalDate fechaeExamen) {
        this.fechaeExamen = fechaeExamen;
    }

    public String getImagenExamen() {
        return imagenExamen;
    }

    public void setImagenExamen(String imagenExamen) {
        this.imagenExamen = imagenExamen;
    }
}
