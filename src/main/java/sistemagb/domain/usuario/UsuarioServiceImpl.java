package sistemagb.domain.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		if(usuarioRepository.findByUsername(usuarioDTO.getUsername()) != null){
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe um usuario cadastrado!");
		}
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario();
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setPassword(bc.encode(usuarioDTO.getPassword()));
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setAtivo(true);
		usuario.setRoles(usuarioDTO.getRoles());
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	@Override
	public Usuario atualizar(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> 
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
		
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setNome(usuarioDTO.getNome());
		
		if(usuarioDTO.getPassword() != null) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			usuario.setPassword(bc.encode(usuarioDTO.getPassword()));
		}
		
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setRoles(usuarioDTO.getRoles());
		
		return usuarioRepository.saveAndFlush(usuario);
	}


}
