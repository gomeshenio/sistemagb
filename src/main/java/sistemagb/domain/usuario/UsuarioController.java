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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"usuario"})
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
//	@RollesAllowed({"ROLE_ADMIN"})
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{username}")
	public Usuario buscarPorNome(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	@PostMapping
	public Usuario criar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.criar(usuarioDTO);
	}
	
	@PutMapping(value = "/{id}")
	public Usuario atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.atualizar(id, usuarioDTO);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
}