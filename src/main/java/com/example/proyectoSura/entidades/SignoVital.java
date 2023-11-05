package com.example.proyectoSura.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "signosVitales")
public class SignoVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombresSignoVital", length = 50, nullable = false)
    private String nombre;
    @Column(name = "unidadDeMedida", nullable = false)
    private Integer unidadMedida;
    @Column(name = "maximoNormal", nullable = false)
    private Double maximoNormal;
    @Column(name = "minimoNormal", nullable = false)
    private Double minimoNormal;
    @Column(name = "fechaDeLaMuestra", nullable = false)
    private LocalDate fechaDeLaMuestra;

    public SignoVital() {
    }

    public SignoVital(Integer id, String nombre, Integer unidadMedida, Double maximoNormal, Double minimoNormal, LocalDate fechaDeLaMuestra) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.maximoNormal = maximoNormal;
        this.minimoNormal = minimoNormal;
        this.fechaDeLaMuestra = fechaDeLaMuestra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Integer unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getMaximoNormal() {
        return maximoNormal;
    }

    public void setMaximoNormal(Double maximoNormal) {
        this.maximoNormal = maximoNormal;
    }

    public Double getMinimoNormal() {
        return minimoNormal;
    }

    public void setMinimoNormal(Double minimoNormal) {
        this.minimoNormal = minimoNormal;
    }

    public LocalDate getFechaDeLaMuestra() {
        return fechaDeLaMuestra;
    }

    public void setFechaDeLaMuestra(LocalDate fechaDeLaMuestra) {
        this.fechaDeLaMuestra = fechaDeLaMuestra;
    }
}
