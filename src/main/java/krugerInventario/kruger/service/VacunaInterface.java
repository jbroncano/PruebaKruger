package krugerInventario.kruger.service;

import org.springframework.http.ResponseEntity;


import krugerInventario.kruger.dto.Vacuna;
import krugerInventario.kruger.model.Response;



public interface VacunaInterface {

	 ResponseEntity<Response> guardarVacuna(Vacuna request);
	 
	 ResponseEntity<Response> listarVacuna();
}
