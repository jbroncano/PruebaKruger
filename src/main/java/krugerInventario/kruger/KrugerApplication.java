package krugerInventario.kruger;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import krugerInventario.kruger.dao.RolDAO;
import krugerInventario.kruger.dao.UsuarioDAO;
import krugerInventario.kruger.dto.Rol;
import krugerInventario.kruger.dto.Usuario;

 
@SpringBootApplication
public class KrugerApplication {

	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	RolDAO rolDAO;
	public static void main(String[] args) {
		SpringApplication.run(KrugerApplication.class, args);
	}

	@Bean
	InitializingBean insertAdmin(){
		
		return ()->{
			Optional<Rol> rol= rolDAO.findById(Rol.ROL_ADMIN);
			if(!rol.isPresent()) {
				Rol roladd=new Rol();
				roladd.setNombre("Admin");
				rolDAO.save(roladd);
			}
			
			Optional<Rol> rolEmp= rolDAO.findById(Rol.ROL_EMPLEADO);
			if(!rolEmp.isPresent()) {
				Rol roladd=new Rol();
				roladd.setNombre("Empleado");
				rolDAO.save(roladd);
			}
			
			
			Usuario user= usuarioDAO.findByUsuario("kruger");
			if(user==null) {
				Usuario usuario = new Usuario("kruger", "admin", Rol.ROL_ADMIN,null);
				usuarioDAO.save(usuario);
			}
		};
	}

}
