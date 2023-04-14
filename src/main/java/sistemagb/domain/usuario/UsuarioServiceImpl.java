package sistemagb.domain.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	

	@Override
	public Usuario criar(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setAtivo(usuarioDTO.getAtivo());
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	@Override
	public Usuario atualizar(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> 
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
		
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setAtivo(usuarioDTO.getAtivo());
		
		return usuarioRepository.saveAndFlush(usuario);
	}


}
