package krugerInventario.kruger.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.model.EmpleadoReq;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.model.VacunacionReq;
import krugerInventario.kruger.service.impl.InventarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/empleado")
@Api(tags = "Interfaz para Administrador", produces = "application/json", consumes = "application/json")
public class InventoryAdminController {

    @Autowired
    InventarioService empleadoServ;
  

 
    @ApiOperation("API para registrar los empleados")
    @PostMapping
    public ResponseEntity<Response> registrarEmpleado(@Valid @RequestBody EmpleadoReq  request) {

        return empleadoServ.guardarEmpleado(request);
    }
    


    @ApiOperation("API para editar empleados")
    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody EmpleadoReq request) {
        return empleadoServ.actualizarEmpleado(id, request);
    }
    

    @ApiOperation("API para obetener los empleados")
    @GetMapping
    public ResponseEntity<Response> listarEmpleado() {

        return empleadoServ.listarEmpleados();
    }
    

    @ApiOperation("API para obetener los empleados")
    @PostMapping("/filter")
    public ResponseEntity<Response> buscarEmpleado(@RequestBody VacunacionReq resques) {

        return empleadoServ.buscarEmpleado(resques);
    }

}
