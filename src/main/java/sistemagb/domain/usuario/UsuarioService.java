package sistemagb.domain.usuario;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
	
	Usuario criar(UsuarioDTO usuarioDTO);
	Usuario atualizar(Long id, UsuarioDTO usuarioDTO);

}
