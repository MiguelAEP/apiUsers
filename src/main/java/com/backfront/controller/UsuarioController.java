package com.backfront.controller;

import com.backfront.entidad.Usuario;
import com.backfront.entidad.enums.GeneroEnum;
import com.backfront.servicio.UsuarioServiceIMP;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioServiceIMP usuarioServiceIMP;


    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioServiceIMP.mostrarUsuarios();
    }

    @GetMapping("/generos")
    public List<Usuario> listarUsuarios(@RequestParam GeneroEnum generoEnum){
        return usuarioServiceIMP.listarUsuarioPorGenero(generoEnum);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioServiceIMP.buscarUsuarioPorId(id).get());
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario( @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioServiceIMP.crearUsuario(usuario),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario , @PathVariable Integer id){
        return new ResponseEntity<>(usuarioServiceIMP.actualizarUsuario(usuario,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario( @PathVariable Integer id){
        usuarioServiceIMP.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/existeDocumento/{numeroDocumento}")
    public boolean existeNumeroDocumento(@PathVariable Integer numeroDocumento){
    //    int documento = Integer.parseInt(numeroDocumento);
        return usuarioServiceIMP.existeNumeroDeDocumento(numeroDocumento);
    }

}
