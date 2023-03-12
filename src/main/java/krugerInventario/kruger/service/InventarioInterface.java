package krugerInventario.kruger.service;


import org.springframework.http.ResponseEntity;

import krugerInventario.kruger.model.EmpleadoReq;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.model.VacunacionReq;



public interface InventarioInterface {

	 ResponseEntity<Response> guardarEmpleado(EmpleadoReq request);
	 
	 ResponseEntity<Response> listarEmpleados();
	 
	 ResponseEntity<Response> actualizarEmpleado(Integer id,EmpleadoReq request);
	 ResponseEntity<Response> buscarEmpleado(VacunacionReq resques);
}
