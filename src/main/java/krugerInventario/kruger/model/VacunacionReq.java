package krugerInventario.kruger.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import krugerInventario.kruger.dto.Usuario;
import krugerInventario.kruger.dto.Vacunacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Modelo de request para buscar  empleado", value = "VacunacionReq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacunacionReq {

	Long vacuna;
	String estadoVacunacion;
	Date fechaDesde;
	Date fechaHasta;
}
