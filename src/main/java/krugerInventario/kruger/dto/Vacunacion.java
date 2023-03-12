package krugerInventario.kruger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@ApiModel(description = "Modelo Vacunacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Vacunacion {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_vacunacion;

    private Date fechaVacunacion;

    private String estadoVacunacion;
    
    private Integer empleado_id;
    
    private Integer vacuna_id;

    @Column(unique = true)
    private Integer dosis;

    @OneToOne
    @JoinColumn(name = "vacuna_id",insertable=false, updatable = false)
    Vacuna vacuna;
    
    @OneToOne
    @JoinColumn(name = "empleado_id",insertable=false, updatable = false)
    Empleado empleado;


}
