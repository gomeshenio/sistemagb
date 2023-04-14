package sistemagb.domain.usuario;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@RequestMapping({"usuario"})
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	private UsuarioRepositoryImpl usuarioRepositoryImpl;
	
	public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService, 
			UsuarioRepositoryImpl usuarioRepositoryImpl) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioService = usuarioService;
		this.usuarioRepositoryImpl = usuarioRepositoryImpl;
	}
	
	@GetMapping
	@RolesAllowed({"ROLE_ADMIN"})
	public List<UsuarioDTO> listar(@RequestParam(required = false) String username,
			@RequestParam(required = false) String nome,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) Boolean ativo){
		return usuarioRepository.buscarUsuarios(username, nome, email, ativo);
	}
	
	
	@GetMapping(path = "/{username}")
	@RolesAllowed({"ROLE_ADMIN"})
	public Usuario buscarPorNome(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	@PostMapping
	@RolesAllowed({"ROLE_ADMIN"})
	public Usuario criar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.criar(usuarioDTO);
	}
	
	@PutMapping(value = "/{id}")
//	@RolesAllowed({"ROLE_ADMIN"})
	public Usuario atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.atualizar(id, usuarioDTO);
	}
	
    @DeleteMapping("/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity deleteClient(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
}