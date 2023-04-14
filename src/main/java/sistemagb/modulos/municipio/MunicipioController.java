package sistemagb.modulos.municipio;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("municipio")
public class MunicipioController {
	
	private MunicipioRepository municipioRepository;
	

    public MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

//    @GetMapping
//    @RolesAllowed({"ROLE_ADMIN"})
//    public List<Municipio> findAll() {
//        return municipioRepository.findAll();
//    }
//
//    @GetMapping(path = {"/uf/{ufId}"})
//    @RolesAllowed({"ROLE_ADMIN"})
//    public List<Municipio> buscarMunicipioPorUf(@PathVariable("ufId") Integer ufId) {
//        return municipioRepository.buscarMunicipioPorUf(ufId);
//    }

}
