package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.repositorios.AfiliadoRepositorio;
import com.example.proyectoSura.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AfiliadoServicio {
    @Autowired
    private AfiliadoRepositorio afiliadoRepositorio;

    //REGISTRAR AFILIADO
    public Afiliado registrarAfiliado(Afiliado afiliado)throws Exception{
        try {
            return this.afiliadoRepositorio.save(afiliado);
        }catch (Exception error){
            throw new Exception(Enum.ERROR_REGISTRO.getMensaje());
        }
    }

    //CONSULTAR AFILIADOS
    public Afiliado consultarAfiliado(Integer idAfiliado)throws Exception{
        try {
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(idAfiliado);
            if (afiliadoBuscado.isPresent()){ //AQUI ENTRA SI LO ENCUENTRA EN LA BD
                return afiliadoBuscado.get();
            }else { //SI NO LO ENCUENTRA LANZA LA EXCEPCION
                throw new Exception(Enum.AFILIADO_INEXISTENTE.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(Enum.ERROR_EN_CONSULTA.getMensaje());
        }
    }

    //MODIFICAR DATOS AFILIADOS
    //BORRAR AFILIADO

}
