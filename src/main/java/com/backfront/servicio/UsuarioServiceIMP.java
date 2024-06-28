package com.backfront.servicio;

import com.backfront.entidad.Usuario;
import com.backfront.entidad.enums.GeneroEnum;
import com.backfront.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceIMP implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> mostrarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> listarUsuarioPorGenero(GeneroEnum generoEnum) {
        return usuarioRepository.findByGeneroEnum(generoEnum);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {

        Boolean existeDocumentoUsuario = usuarioRepository.findByNumeroDocumento(usuario.getNumeroDocumento()).isPresent();
        if(existeDocumentoUsuario){
            throw new IllegalArgumentException("El numero de documento ya existe");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario , Integer id) {

        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if(existeUsuario.isEmpty()){
            throw new RuntimeException("El usuario que desea actualizar no existe");
        }

        return usuarioRepository.save(usuario);

    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Integer id) {

        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if(existeUsuario.isEmpty()){
            throw new RuntimeException("El usuario que desea buscar no existe");
        }
        return existeUsuario;
    }

    @Override
    public void eliminarUsuario(Integer id) {
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if(existeUsuario.isEmpty()){
            throw new RuntimeException("El usuario que desea eliminar no existe;");
        }

        usuarioRepository.delete(existeUsuario.get());
    }

    @Override
    public boolean existeNumeroDeDocumento(Integer numeroDocumento) {
        return usuarioRepository.existsByNumeroDocumento(numeroDocumento);
    }
}
