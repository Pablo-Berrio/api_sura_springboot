package com.example.proyectoSura.servicios;

import com.example.proyectoSura.entidades.Afiliado;
import com.example.proyectoSura.repositorios.AfiliadoRepositorio;
import com.example.proyectoSura.utilidades.Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    //CONSULTAR AFILIADO
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

    //CONSULTAR AFILIADOS
    public List<Afiliado> buscarTodosLosAfiliados()throws Exception{
        try {
            List<Afiliado>listaConsultada= this.afiliadoRepositorio.findAll();
            return listaConsultada;
        }catch (Exception error){
            throw new Exception(Enum.AFILIADO_INEXISTENTE.getMensaje());
        }
    }

    //MODIFICAR DATOS AFILIADOS
    public Afiliado editarAfiliado(Integer id, Afiliado afiliado)throws Exception{
        try {
            Optional<Afiliado>afiliadoBuscado=this.afiliadoRepositorio.findById(id);
            if (afiliadoBuscado.isPresent()){
                //Afiliado afiliadoEditado=this.afiliadoRepositorio.save(afiliado);
                //return afiliadoEditado;    ESTAS DOS LINEAS LAS USAMOS SI QUEREMOS CAMBIAR TODOS LOS DATOS
                Afiliado afiliadoExistente=afiliadoBuscado.get();
                afiliadoExistente.setDepartamento(afiliado.getDepartamento());
                afiliadoExistente.setTelefono(afiliado.getTelefono());
                Afiliado afiliadoModificado= this.afiliadoRepositorio.save(afiliadoExistente);
                return afiliadoModificado;
            }else {
                throw new Exception("id inexistente");
            }
        }catch (Exception error){
            throw new Exception("no pudimos editar el afiliado");
        }
    }


    //BORRAR AFILIADO
    public Boolean retirarAfiliado(Integer id)throws Exception{
        try {
            Boolean afiliadoEncontrado=this.afiliadoRepositorio.existsById(id);
            if (afiliadoEncontrado){
                this.afiliadoRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception("error al eliminar el afiliado");
        }
    }

}
