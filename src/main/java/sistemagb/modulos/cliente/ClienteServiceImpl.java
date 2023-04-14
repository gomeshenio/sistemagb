package sistemagb.modulos.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sistemagb.modulos.municipio.Municipio;
import sistemagb.modulos.municipio.MunicipioRepository;
import sistemagb.modulos.uf.UF;
import sistemagb.modulos.uf.UfRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@PersistenceContext
	private EntityManager entityManager;
	
	private ClienteRepository clienteRepository;
	private MunicipioRepository municipioRepository;
	private UfRepository ufRepository;


	public ClienteServiceImpl(ClienteRepository clienteRepository, MunicipioRepository municipioRepository,
			UfRepository ufRepository) {
		super();
		this.clienteRepository = clienteRepository;
		this.municipioRepository = municipioRepository;
		this.ufRepository = ufRepository;
	}

	@Override
	public Cliente criarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDTO.getNome());
		cliente.setEndereco(clienteDTO.getEndereco());
		cliente.setRua(clienteDTO.getRua());
		cliente.setNumero(clienteDTO.getNumero());
		cliente.setBairro(clienteDTO.getBairro());
		
		if (clienteDTO.getMunicipioId() != null) {
			Municipio municipio = municipioRepository.findById(clienteDTO.getMunicipioId()).get();
			cliente.setMunicipio(municipio);
		}

		if (clienteDTO.getUfId() != null) {
			cliente.setUf(ufRepository.findById(clienteDTO.getUfId()).get());
		}
		
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setCnpj(clienteDTO.getCnpj());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setTipoPessoa(clienteDTO.getTipoPessoa());
		
		return clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public Cliente atualizarCliente(Cliente cliente, ClienteDTO clienteDTO) {
		cliente.setNome(clienteDTO.getNome());
		cliente.setEndereco(clienteDTO.getEndereco());
		cliente.setRua(clienteDTO.getRua());
		cliente.setNumero(clienteDTO.getNumero());
		cliente.setBairro(clienteDTO.getBairro());
		
		if (clienteDTO.getMunicipioId() != null) {
			Municipio municipio = municipioRepository.findById(clienteDTO.getMunicipioId()).get();
			cliente.setMunicipio(municipio);
		}

		if (clienteDTO.getUfId() != null) {
			cliente.setUf(ufRepository.findById(clienteDTO.getUfId()).get());
		}
		
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setCnpj(clienteDTO.getCnpj());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setTipoPessoa(clienteDTO.getTipoPessoa());
		
		return clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public List<ClienteDTO> buscarCliente() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ClienteDTO> cq = cb.createQuery(ClienteDTO.class);
		Root<Cliente> cliente = cq.from(Cliente.class);

		List<Predicate> predicates = new ArrayList<>();
		Join<Cliente, UF> ufJoin = cliente.join("uf", JoinType.LEFT);
		Join<Cliente, Municipio> municipioJoin = cliente.join("municipio", JoinType.LEFT);
		
		cq.multiselect(
				cliente.get("id"), 
				cliente.get("nome"), 
				cliente.get("endereco"), 
				cliente.get("rua"), 
				cliente.get("numero"),
				cliente.get("bairro"), 
				municipioJoin.get("municipioId"), 
				ufJoin.get("ufId"),
				cliente.get("cpf"),
				cliente.get("cnpj"),
				cliente.get("dataNascimento"),
				cliente.get("tipoPessoa")
			);
	
		cq.where(predicates.toArray(new Predicate[0]));

		return entityManager.createQuery(cq).getResultList();
	}

}
