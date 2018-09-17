package quirobel.es.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import quirobel.es.apirest.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
