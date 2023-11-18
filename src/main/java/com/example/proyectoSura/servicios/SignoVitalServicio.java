package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.entidades.SignoVital;
import com.example.proyectoSura.repositorios.SignoVitalRepositorio;
import com.example.proyectoSura.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SignoVitalServicio {

    @Autowired
    private SignoVitalRepositorio signoVitalRepositorio;

    //REGISTRAR
    public SignoVital registrarSignoVital(SignoVital signoVital)throws Exception{
        try {
            return this.signoVitalRepositorio.save(signoVital);
        }catch (Exception error){
            throw new Exception(Enum.ERROR_REGISTRO.getMensaje());
        }
    }

    //CONSULTAR
    public SignoVital consultarSignoVital(Integer idSignoVital)throws Exception{
        try {
            Optional<SignoVital>signoBuscado=this.signoVitalRepositorio.findById(idSignoVital);
            if (signoBuscado.isPresent()){
                return signoBuscado.get();
            }else {
                throw new Exception(Enum.SIGNO_INEXISTENTE.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Enum.ERROR_EN_CONSULTA.getMensaje());
        }
    }

    //CONSULTAR SIGNOS VITALES
    public List<SignoVital> buscarTodosLosSignosVitales()throws Exception{
        try {
            List<SignoVital>listaConsultada= this.signoVitalRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Enum.EXAMEN_INEXISTENTE.getMensaje());
        }
    }

    //MODIFICAR
    //BORRAR

}
