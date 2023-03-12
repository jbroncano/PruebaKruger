package krugerInventario.kruger.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import krugerInventario.kruger.dto.Vacunacion;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.service.impl.VacunacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/empleado/vacunacion")
@Api(tags = "Interfaz para Empleado", produces = "application/json", consumes = "application/json")
public class VacunacionController {

    @Autowired
    VacunacionService vacunacionServ;

 
    @ApiOperation("API para registrar los empleados")
    @PostMapping
    public ResponseEntity<Response> registrarVacunacion(@Valid @RequestBody Vacunacion  request) {

        return vacunacionServ.guardarVacunacion(request);
    }

    @ApiOperation("API para obetener los empleados")
    @GetMapping
    public ResponseEntity<Response> listarVacunacion() {

        return vacunacionServ.listarVacunacion();
    }

}
