package krugerInventario.kruger.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Vacuna;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, Integer> {


	    @Query(value = "SELECT e\n" +
	            "FROM Empleado e \n" +
	            "JOIN Vacunacion v on v.empleado_id= e.id_empleado " +
	            "JOIN Vacuna va on va.id_vacuna = v.vacuna_id \n" +
	            "WHERE va.id_vacuna = ?1")
	    List<Object[]> filterEmpleadoByVacuna(Long tipoVacuna);

	    @Query(value = "SELECT e \n" +
	            "FROM Empleado e \n" +
	            "JOIN Vacunacion v on v.empleado_id= e.id_empleado " +
	            "WHERE v.estadoVacunacion = ?1")
	    List<Object[]> filterEmpleadoByEstadoVacuna(String estadoVacuna);
	    
		 @Query(value = "SELECT e \n" +
		            "FROM Empleado e \n" +
		            "JOIN Vacunacion v on v.empleado_id= e.id_empleado " +
		            "WHERE v.fechaVacunacion between ?1 and ?2")
		    List<Object[]> filterEmpleadoByDate(Date fechaDesde, Date fechaHasta);



}
