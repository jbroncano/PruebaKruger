package krugerInventario.kruger.model;

import io.swagger.annotations.ApiModel;
import krugerInventario.kruger.dto.Usuario;
import krugerInventario.kruger.dto.Vacunacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@ApiModel(description = "Modelo de request para registro de empleado", value = "EmpleadoReq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoReq {

    @NotNull(message = "Parametro identificacion no debe ser null")
    @Size(min = 10, max = 10, message = "Parametro dni debe tener 10 digitos")
    private String identificacion;
    @NotNull(message = "Parametro nombre no debe ser null")
    private String nombres;
    @NotNull(message = "Parametro apellidos no debe ser null")
    private String apellidos;
    @NotNull
    @Email(regexp = "^(.+)@(.+)$", message = "Correo invalido")
    private String correo;   
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date fechaNacimiento;
    @NotNull(message = "Parametro telefono no debe ser null")
    private String telefono;  
    private String estado;
    @NotNull(message = "Parametro direccionDomicilio no debe ser null")
    private String direccionDomicilio;
    private Vacunacion vacunacion;
    private Usuario usuario;

}
