package sistemagb.domain.usuario;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import sistemagb.domain.role.Role;
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
	
	private EntityManager entityManager;
	
	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	public List<UsuarioDTO> buscarUsuarios() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsuarioDTO> cq = cb.createQuery(UsuarioDTO.class);
		Root<Usuario> usuario = cq.from(Usuario.class);
		
		Join<Usuario, Role> role = usuario.join("roles", JoinType.INNER);
		
		cq.multiselect(
				usuario.get("id"),
				usuario.get("username"),
				usuario.get("nome"),
				usuario.get("password"),
				usuario.get("email"),
				usuario.get("ativo"),
				usuario.get("roles")
				);
		
		cq.distinct(true);
		cq.orderBy(cb.asc(usuario.get("nome")));

		return entityManager.createQuery(cq).getResultList();
	}
	
	

}
