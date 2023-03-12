package krugerInventario.kruger.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import krugerInventario.kruger.dto.Rol;
import krugerInventario.kruger.dto.Usuario;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String user);
}
