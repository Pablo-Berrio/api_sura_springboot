package com.example.proyectoSura.controladores;

import com.example.proyectoSura.entidades.Examen;
import com.example.proyectoSura.entidades.SignoVital;
import com.example.proyectoSura.servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sura/signoVital")
public class SignoVitalControlador {

    @Autowired
    private SignoVitalServicio signoVitalServicio;
    //AGREGAR SIGNO VITAL
    @PostMapping
    public ResponseEntity<?> agrgearSignoVital(@RequestBody SignoVital signoVital){
        try {
            SignoVital respuestaServicio=this.signoVitalServicio.registrarSignoVital(signoVital);
                    return ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //BUSCAR SIGNO VITAL
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarSignoVital(@PathVariable Integer id){
        try {
            SignoVital respuestaServicio= this.signoVitalServicio.consultarSignoVital(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }



}
