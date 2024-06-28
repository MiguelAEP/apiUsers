package com.backfront.entidad;

import com.backfront.entidad.enums.AreaEnum;
import com.backfront.entidad.enums.GeneroEnum;
import com.backfront.entidad.enums.TipoDocumentEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;


    @Enumerated(EnumType.STRING)
    @Column(name = "usuarioEnum")
    private TipoDocumentEnum usuarioEnum;

    @Column(name = "numeroDocumento")
    private Integer numeroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "generoEnum")
    private GeneroEnum generoEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "areaEnum")
    private AreaEnum areaEnum;



}
