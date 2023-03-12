package krugerInventario.kruger.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import krugerInventario.kruger.dao.UsuarioDAO;
import krugerInventario.kruger.dto.Empleado;
import krugerInventario.kruger.dto.Rol;
import krugerInventario.kruger.dto.Usuario;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class UsuarioService {
	  @Autowired
	  UsuarioDAO usuarioDAO;
	
	
    public Usuario generaUsuario(Empleado empleado) throws NoSuchPaddingException, NoSuchAlgorithmException {
        String apellido =empleado.getApellidos().split(" ")[0];
        String nombre =empleado.getNombres().split(" ")[0];

        StringBuilder str = new StringBuilder();
        str.append(nombre.charAt(0)).append(apellido).append(1);
        String user = str.toString();
        log.info(str.toString());
        Usuario usuario;
        while (true) {
            usuario = usuarioDAO.findByUsuario(user);
            if (usuario != null) {
                char lastChar = usuario.getUsuario().charAt(usuario.getUsuario().length() - 1);
                int num = Character.getNumericValue(lastChar);
                num++;
                user = user.substring(0, user.length() - 1);
                user += num;
            } else {
                break;
            }
        }
        usuario = new Usuario(user.toLowerCase(),empleado.getIdentificacion(), Rol.ROL_EMPLEADO,empleado.getId_empleado());
        usuario = usuarioDAO.save(usuario);

        return usuario;
    }
}
