package com.backfront.servicio;

import com.backfront.entidad.Usuario;
import com.backfront.entidad.enums.GeneroEnum;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> mostrarUsuarios();

    public List<Usuario> listarUsuarioPorGenero(GeneroEnum generoEnum);

    public Usuario crearUsuario(Usuario usuario);

    public Usuario actualizarUsuario(Usuario usuario , Integer id);

    public Optional<Usuario> buscarUsuarioPorId(Integer id);

    public void eliminarUsuario(Integer id);

    public boolean existeNumeroDeDocumento(Integer numeroDocumento);



}
