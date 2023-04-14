package sistemagb.domain.usuario;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryCustom {
	
	List<UsuarioDTO> buscarUsuarios();

}
