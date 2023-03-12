package krugerInventario.kruger.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@ApiModel(description = "Modelo Rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Rol {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_rol;
    private String nombre;

    
    public final static Integer ROL_EMPLEADO=2;
    public final static Integer ROL_ADMIN=1;
    
}
