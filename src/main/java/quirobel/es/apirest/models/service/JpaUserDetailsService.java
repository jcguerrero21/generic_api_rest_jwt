package quirobel.es.apirest.models.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quirobel.es.apirest.models.entity.Role;
import quirobel.es.apirest.models.entity.UsuarioRol;
import quirobel.es.apirest.models.dao.IUsuarioDao;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioRol usuarioRol = usuarioDao.findByUsername(username);

        if (usuarioRol == null) {
            logger.error("Error en el Login: no existe el usuarioRol '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : usuarioRol.getRoles()) {
            logger.info("Role: ".concat(role.getAuthority()));
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (authorities.isEmpty()) {
            logger.error("Error en el Login: UsuarioRol '" + username + "' no tiene roles asignados!");
            throw new UsernameNotFoundException("Error en el Login: usuarioRol '" + username + "' no tiene roles asignados!");
        }

        return new User(usuarioRol.getUsername(), usuarioRol.getPassword(), usuarioRol.getEnabled(), true, true, true, authorities);
    }
}


