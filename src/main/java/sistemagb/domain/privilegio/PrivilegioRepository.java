package sistemagb.domain.privilegio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Long>{
	Privilegio findByName(String nome);

}
