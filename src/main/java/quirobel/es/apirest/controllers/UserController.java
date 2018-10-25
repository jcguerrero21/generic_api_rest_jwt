package quirobel.es.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import quirobel.es.apirest.auth.JwtTokenUtil;
import quirobel.es.apirest.auth.service.JWTService;
import quirobel.es.apirest.models.dao.IUsuarioDao;
import quirobel.es.apirest.models.entity.Role;
import quirobel.es.apirest.models.entity.UsuarioRol;
import quirobel.es.apirest.models.service.JpaUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static quirobel.es.apirest.auth.SecurityConstans.HEADER_STRING;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/insertar-usuario")
    public void insertUsuario(@RequestBody UsuarioRol usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        if(usuario.getRoles() == null) {
            usuario.setRoles(this.insertarRoleUsuario());
        }
        usuario.setEnabled(true);
        iUsuarioDao.save(usuario);
    }

    private List<Role> insertarRoleUsuario(){
        List<Role> rolUsuario = new ArrayList<>();
        Role rol = new Role().setAuthority("ROLE_USER");
        rolUsuario.add(rol);
        return rolUsuario;
    }
}
