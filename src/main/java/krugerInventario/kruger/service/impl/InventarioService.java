package krugerInventario.kruger.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import krugerInventario.kruger.dao.EmpleadoDAO;
import krugerInventario.kruger.dao.VacunacionDAO;
import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Usuario;
import krugerInventario.kruger.model.EmpleadoReq;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.model.VacunacionReq;
import krugerInventario.kruger.service.InventarioInterface;
import krugerInventario.kruger.util.Validar;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class InventarioService implements InventarioInterface {
    @Autowired
    EmpleadoDAO empleadoDAO;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    VacunacionDAO vacunacionDao;
  
	
	 /**
     * Funcion para guardar los empleados
     *
     * @param request Objeto de tipo EmpleadoReq para registrar en la base
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> guardarEmpleado(EmpleadoReq request) {

        Response resp = new Response();
        Validar valid = new Validar();
        try {
            if (valid.validIdentificacion(request.getIdentificacion()) && valid.validStrings(request.getNombres())
                    && valid.validStrings(request.getApellidos())) {
            	
            	request.setEstado("Pendiente");
            	Empleado empleado=  new Gson().fromJson((new Gson().toJson(request)), Empleado.class);
                empleadoDAO.save(empleado);
                resp.setCode(200);
                resp.setMessage("OK");
                resp.setResponse(empleado);
                return ResponseEntity.status(HttpStatus.CREATED).body(resp);
            } else {
                resp.setCode(400);
                resp.setMessage("Request Invalido");
                return ResponseEntity.status(HttpStatus.OK).body(resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
    
    
	 /**
     * Funcion para en listar todos los empleados
     *
     * 
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> listarEmpleados() {
        Response resp = new Response();
        try {
            List<Empleado> listEmpleado = empleadoDAO.findAll();
            resp.setCode(200);
            resp.setMessage("OK");
            resp.setResponse(listEmpleado);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
	 /**
     * Funcion para en Actualizar empleado todos los empleados
     *
     * 
     * Si es estado es Acitvo se da Alta y se genera el Usuairo del Empleado
     * @return Status del servicio con la respuesta del formato Response.class
     */
    @Override
    public ResponseEntity<Response> actualizarEmpleado(Integer id,EmpleadoReq request) {
        Response resp = new Response();
        try {
            Optional<Empleado> optEmpleado = empleadoDAO.findById(id);
        	if(!optEmpleado.isPresent()) {
    			throw new Exception("No existe empleado");
    		}
        	Empleado empleado=optEmpleado.get();
        	empleado.setApellidos(request.getApellidos());
        	empleado.setIdentificacion(request.getIdentificacion());
        	empleado.setNombres(request.getNombres());
        	empleado.setTelefono(request.getTelefono());
        	empleado.setFechaNacimiento(request.getFechaNacimiento());
        	empleado.setCorreo(request.getCorreo());
        	empleado.setDireccionDomicilio(request.getDireccionDomicilio());
        	resp.setResponse(empleado);
        	resp.setMessage("OK");
        	empleadoDAO.save(empleado);
        	if(request.getEstado().equalsIgnoreCase("Activo") && request.getUsuario()==null) {
        		empleado.setEstado(request.getEstado());
        		Usuario usu=this.usuarioService.generaUsuario(empleado);
        		resp.setMessage("Empleado dado de Alta Usuario generado");
        		resp.setResponse(usu);
        	}        	
            resp.setCode(200);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.setCode(400);
            resp.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }
   
   @Override
   public ResponseEntity<Response> buscarEmpleado(VacunacionReq resques){
	   Response resp = new Response();
       try {
    	   List<Empleado> lstEmpleado=new ArrayList<Empleado>();
    	   List<Object[]> lstempleado=null;
    	     if (resques.getEstadoVacunacion() != null && !resques.getEstadoVacunacion().isEmpty()) {
    	    	 lstempleado = empleadoDAO.filterEmpleadoByEstadoVacuna(resques.getEstadoVacunacion());
             } else if (resques.getVacuna() != null && resques.getVacuna()!=null) {
            	 lstempleado = empleadoDAO.filterEmpleadoByVacuna(resques.getVacuna());
             } else if (resques.getFechaDesde() != null && resques.getFechaHasta() != null) {
            	 lstempleado = empleadoDAO.filterEmpleadoByDate(resques.getFechaDesde(), resques.getFechaHasta());

             } else {
                 resp.setCode(400);
                 resp.setMessage("Filtros incorrectos");
             }
          if (lstempleado != null) {
        	  for (Object[] objects : lstempleado) {
        		  if( objects[0]!=null) {
            		  lstEmpleado.add((Empleado) objects[0]);
        		  }

			}
              resp.setCode(0);
              resp.setMessage(lstEmpleado.isEmpty()? "No hay registros" : "OK");
          }
    	  resp.setCode(200);
    	  resp.setResponse(lstEmpleado);
           return ResponseEntity.status(HttpStatus.OK).body(resp);
       } catch (Exception e) {
       log.error(e.getMessage());
       resp.setCode(400);
       resp.setMessage(e.getMessage());
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
   }
       
    }
    
}
