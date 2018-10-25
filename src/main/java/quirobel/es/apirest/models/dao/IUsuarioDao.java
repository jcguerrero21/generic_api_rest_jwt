package quirobel.es.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import quirobel.es.apirest.models.entity.UsuarioRol;

public interface IUsuarioDao extends CrudRepository<UsuarioRol, Long> {

    UsuarioRol findByUsername(String username);

}
