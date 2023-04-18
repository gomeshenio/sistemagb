package sistemagb.modulos.municipio;


import java.util.List;

import sistemagb.modulos.uf.UF;

public interface MunicipioRepositoryCustom {
	
	List<Municipio> findByUf(Integer idUf);
//	Municipio findByNome(UF uf, String nome);

}
