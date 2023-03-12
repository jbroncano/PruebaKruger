package krugerInventario.kruger.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@ApiModel(description = "Modelo Vacunacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Usuario {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;

    private String usuario;
    private String contrasena;
    private Integer id_rol;
    private Integer id_empleado;
    
   
    
    @OneToOne
    @JoinColumn(name = "id_empleado",insertable=false, updatable = false)
    Empleado empleado;
    
    @OneToOne
    @JoinColumn(name = "id_rol",insertable=false, updatable = false)
    Rol rol;


    public Usuario(String usuario, String password, Integer rol,Integer empleado) {
        this.usuario = usuario;
        this.contrasena = password;
        this.id_rol = rol;
        this.id_empleado = empleado;
    }
}
