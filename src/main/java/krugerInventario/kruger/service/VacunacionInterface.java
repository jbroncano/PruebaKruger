package krugerInventario.kruger.service;

import org.springframework.http.ResponseEntity;

import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Vacunacion;
import krugerInventario.kruger.model.Response;



public interface VacunacionInterface {

	 ResponseEntity<Response> guardarVacunacion(Vacunacion request);
	 
	 ResponseEntity<Response> listarVacunacion();
}
