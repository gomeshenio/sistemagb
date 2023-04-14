package sistemagb.modulos.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
		super();
		this.clienteService = clienteService;
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	@RolesAllowed({"ROLE_ADMIN"})
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN"})
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(clienteRepository.findById(id).orElseThrow(()-> 
		new IllegalArgumentException("Cliente não encontrado")));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@RolesAllowed({"ROLE_ADMIN"})
	public Cliente criarCliente(@RequestBody ClienteDTO clienteDTO) {
		return clienteService.criarCliente(clienteDTO);
	}
	
	@PutMapping(value = "/{id}")
	@RolesAllowed({"ROLE_ADMIN"})
	public Cliente atualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteRepository.getById(id);
		cliente = clienteService.atualizarCliente(cliente, clienteDTO);
		return clienteRepository.saveAndFlush(cliente);
	}
	
    @DeleteMapping("/{id}")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
