package sistemagb.modulos.uf;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "uf" })
public class UfController {
	
	private UfRepository ufRepository;

	public UfController(UfRepository ufRepository) {
		this.ufRepository = ufRepository;
	}

	@GetMapping
	public List<UF> findAll() {
		return ufRepository.findAll(Sort.by(Sort.Direction.ASC, "sigla"));
	}

}
