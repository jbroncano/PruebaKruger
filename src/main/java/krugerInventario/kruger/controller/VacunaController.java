package krugerInventario.kruger.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Vacuna;
import krugerInventario.kruger.model.Response;
import krugerInventario.kruger.service.impl.InventarioService;
import krugerInventario.kruger.service.impl.VacunaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/vacuna")
@Api(tags = "Interfaz para Administrador", produces = "application/json", consumes = "application/json")
public class VacunaController {

    @Autowired
    VacunaService vacunaServ;

 
    @ApiOperation("API para registrar los empleados")
    @PostMapping
    public ResponseEntity<Response> registrarVacunacion(@Valid @RequestBody Vacuna  request) {

        return vacunaServ.guardarVacuna(request);
    }

    @ApiOperation("API para obetener los empleados")
    @GetMapping
    public ResponseEntity<Response> listarVacuna() {

        return vacunaServ.listarVacuna();
    }
}
