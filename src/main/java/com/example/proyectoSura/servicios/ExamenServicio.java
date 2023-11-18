package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.entidades.Examen;
import com.example.proyectoSura.repositorios.ExamenRepositorio;
import com.example.proyectoSura.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExamenServicio {

    @Autowired
    private ExamenRepositorio examenRepositorio;

    //REGISTRAR
    public Examen registrarExamen(Examen examen)throws Exception{
        try {
            return this.examenRepositorio.save(examen);
        }catch (Exception error){
            throw new Exception(Enum.ERROR_REGISTRO.getMensaje());
        }
    }

    //CONSULTAR
    public Examen consultarExamen(Integer idExamen)throws Exception{
        try {
            Optional<Examen>examenBuscado=this.examenRepositorio.findById(idExamen);
            if (examenBuscado.isPresent()){
                return examenBuscado.get();
            }else {
                throw new Exception(Enum.EXAMEN_INEXISTENTE.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Enum.ERROR_EN_CONSULTA.getMensaje());
        }
    }

    //CONSULTAR EXAMENES
    public List<Examen> buscarTodosLosExamenes()throws Exception{
        try {
            List<Examen>listaConsultada= this.examenRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Enum.EXAMEN_INEXISTENTE.getMensaje());
        }
    }

    //MODIFICAR
    //BORRAR

}
