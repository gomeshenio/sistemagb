package sistemagb.modulos.uf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<UF, Integer>{
	
	UF findBySigla(String sigla);

}
