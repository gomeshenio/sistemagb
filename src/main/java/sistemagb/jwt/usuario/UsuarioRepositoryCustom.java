package sistemagb.jwt.usuario;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Repository
public interface UsuarioRepositoryCustom {
//	List<Usuario> buscarUsuarios(String username, String nome, String email, Boolean ativo);
	List<UsuarioDTO> buscarUsuarios(String username, String nome, String email, Boolean ativo);
}

