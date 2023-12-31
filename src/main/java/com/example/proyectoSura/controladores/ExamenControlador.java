package com.example.proyectoSura.controladores;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.entidades.Examen;
import com.example.proyectoSura.servicios.ExamenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/examenes")
public class ExamenControlador {

    @Autowired
    private ExamenServicio examenServicio;
    //AGREGAR EXAMEN
    @PostMapping
    public ResponseEntity<?> agregarExamen(@RequestBody Examen examen){
        try {
            Examen respuestaServicio=this.examenServicio.registrarExamen(examen);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    
    //BUSCAR EXAMEN
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarExamen(@PathVariable Integer id){
        try {
            Examen respuestaServicio= this.examenServicio.consultarExamen(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Examen>> consultarExamenes(){
        try {
            List<Examen>listaConsultada=this.examenServicio.buscarTodosLosExamenes();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaConsultada);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    //BORRAR
    public ResponseEntity<?> eliminarExamen(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.examenServicio.retirarExamen(id));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
