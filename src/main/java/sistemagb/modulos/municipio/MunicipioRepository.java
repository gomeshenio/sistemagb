package sistemagb.modulos.municipio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>, MunicipioRepositoryCustom {

}
