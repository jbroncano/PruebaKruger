package krugerInventario.kruger.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import krugerInventario.kruger.dao.EmpleadoDAO;
import krugerInventario.kruger.dao.VacunaDAO;
import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Usuario;
import krugerInventario.kruger.dto.Vacuna;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.service.InventarioInterface;
import krugerInventario.kruger.service.VacunaInterface;
import krugerInventario.kruger.util.Validar;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class VacunaService implements VacunaInterface {
    @Autowired
    VacunaDAO vacunaDAO;
	
	 /**
     * Funcion para guardar los empleados
     *
     * @param request Objeto de tipo EmpleadoReq para registrar en la base
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> guardarVacuna(Vacuna request) {

        Response resp = new Response();
        try {
            	vacunaDAO.save(request);
                resp.setCode(200);
                resp.setMessage("OK");
                resp.setResponse(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
    
    @Override
    public ResponseEntity<Response> listarVacuna() {
        Response resp = new Response();
        try {
            List<Vacuna> listVacuna = vacunaDAO.findAll();

            resp.setCode(200);
            resp.setMessage("OK");
            resp.setResponse(listVacuna);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
}
