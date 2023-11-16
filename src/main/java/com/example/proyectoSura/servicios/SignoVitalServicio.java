package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.SignoVital;
import com.example.proyectoSura.repositorios.SignoVitalRepositorio;
import com.example.proyectoSura.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //MODIFICAR
    //BORRAR

}
