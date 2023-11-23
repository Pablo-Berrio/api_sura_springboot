package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.entidades.Examen;
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
    public SignoVital editarSignoVital(Integer id, SignoVital signoVital)throws Exception{
        try {
            Optional<SignoVital>signoVitalBuscado=this.signoVitalRepositorio.findById(id);
            if (signoVitalBuscado.isPresent()){
                SignoVital signoVitalExistente=signoVitalBuscado.get();
                signoVitalExistente.setUnidadMedida(signoVital.getUnidadMedida());
                SignoVital signoVitalModificado= this.signoVitalRepositorio.save(signoVitalExistente);
                return signoVitalModificado;
            }else {
                throw new Exception("id inexistente");
            }
        }catch (Exception error){
            throw new Exception("no pudimos editar el signo vital");
        }
    }

    //BORRAR
    public Boolean retirarSignoVital(Integer id)throws Exception{
        try {
            Boolean signoVitalEncontrado=this.signoVitalRepositorio.existsById(id);
            if (signoVitalEncontrado){
                this.signoVitalRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("signo vital no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error al eliminar el signo vital");
        }
    }

}
