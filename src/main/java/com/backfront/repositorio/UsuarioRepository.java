package com.backfront.repositorio;

import com.backfront.entidad.Usuario;
import com.backfront.entidad.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    public Optional<Usuario> findByNumeroDocumento(Integer numeroDocumento);

    public boolean existsByNumeroDocumento(Integer numeroDocumento);

    public List<Usuario> findByGeneroEnum(GeneroEnum generoEnum);

}
