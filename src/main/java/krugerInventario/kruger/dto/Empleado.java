package krugerInventario.kruger.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@ApiModel(description = "Modelo Empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_empleado;

    @Column(nullable = false, unique = true)
    private String identificacion;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false, unique = true)
    private String correo;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date fechaNacimiento;

    private String telefono;
    
    private String estado;
    private String direccionDomicilio;





}
