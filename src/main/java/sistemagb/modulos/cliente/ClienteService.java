package sistemagb.modulos.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

	Cliente criarCliente(ClienteDTO clienteDTO);
	
	Cliente atualizarCliente(Cliente cliente, ClienteDTO clienteDTO);
	
	List<ClienteDTO> buscarCliente();
}
