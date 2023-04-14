package sistemagb.jwt.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sistemagb.jwt.role.Role;
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {
	
	private EntityManager entityManager;
	
	

	public UsuarioRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



//	@Override
//	public List<Usuario> buscarUsuarios(String username, String nome, String email, Boolean ativo) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
//		Root<Usuario> usuario = cq.from(Usuario.class);
//		
//		Join<Usuario, Role> role = usuario.join("roles", JoinType.LEFT);
//		
//		List<Predicate> predicates = new ArrayList<>();
//		
//		if (username != null) {
//			predicates.add(cb.like(cb.lower(usuario.get("username")), "%" + username.toLowerCase() + "%"));
//		}
//		
//		if (nome != null) {
//			predicates.add(cb.like(cb.lower(usuario.get("nome")), "%" + nome.toLowerCase() + "%"));
//		}
//		
//		if (email != null) {
//			predicates.add(cb.equal(usuario.get("email"), email));
//		}
//		
//		if (username != null) {
//			predicates.add(cb.equal(usuario.get("username"), username));
//		}
//		
//		cq.multiselect(
//				usuario.get("id"),
//				usuario.get("username"),
//				usuario.get("nome"),
//				usuario.get("password"),
//				usuario.get("email"),
//				usuario.get("ativo")
//				);
//		
//		cq.where(predicates.toArray(new Predicate[0])).distinct(true);
//		cq.orderBy(cb.asc(usuario.get("nome")));
//		
//		return entityManager.createQuery(cq).getResultList();
//	}


	@Override
	public List<UsuarioDTO> buscarUsuarios(String username, String nome, String email, Boolean ativo) {
	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	CriteriaQuery<UsuarioDTO> cq = cb.createQuery(UsuarioDTO.class);
	Root<Usuario> usuario = cq.from(Usuario.class);
	
	Join<Usuario, Role> role = usuario.join("roles", JoinType.LEFT);
	
	
	List<Predicate> predicates = new ArrayList<>();
	
	if (username != null) {
		predicates.add(cb.like(cb.lower(usuario.get("username")), "%" + username.toLowerCase() + "%"));
	}
	
	if (nome != null) {
		predicates.add(cb.like(cb.lower(usuario.get("nome")), "%" + nome.toLowerCase() + "%"));
	}
	
	if (email != null) {
		predicates.add(cb.equal(usuario.get("email"), email));
	}
	
	if (username != null) {
		predicates.add(cb.equal(usuario.get("username"), username));
	}
	
	
	cq.multiselect(
			usuario.get("id"),
			usuario.get("username"),
			usuario.get("nome"),
			usuario.get("email"),
			usuario.get("ativo")
			);
	
	cq.distinct(true);
	cq.orderBy(cb.asc(usuario.get("nome")));

	return entityManager.createQuery(cq).getResultList();
	}
	
	

}
