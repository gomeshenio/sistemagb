package sistemagb.modulos.municipio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sistemagb.modulos.uf.UF;

@Repository
public class MunicipioRepositoryimpl implements MunicipioRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;

	public MunicipioRepositoryimpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Municipio> findByUf(Integer idUf) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Municipio> cq = cb.createQuery(Municipio.class);
		Root<Municipio> municipio = cq.from(Municipio.class);

		municipio.join("uf", JoinType.LEFT);

		List<Predicate> predicates = new ArrayList<>();

		if (idUf != null) {
			predicates.add(cb.equal(municipio.join("uf"), idUf));
		}

		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<Municipio> query = entityManager.createQuery(cq);
		return query.getResultList();
	}

//	@Override
//	public Municipio findByNome(UF uf, String nome) {
//    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//    	CriteriaQuery<Municipio> cq = cb.createQuery(Municipio.class);
//    	Root<Municipio> municipio = cq.from(Municipio.class);
//    	
//    	municipio.join("uf", JoinType.LEFT);
//    	
//    	List<Predicate> predicates = new ArrayList<>();
//    	
//    	if(uf != null){
//    		predicates.add(cb.equal(municipio.join("uf"), uf));
//    	}
//    	if(nome != null){
//    		predicates.add(cb.equal(municipio.get("nome"), nome));
//    	}
//    	
//    	cq.where(predicates.toArray(new Predicate[0]));
//    	
//    	TypedQuery<Municipio> query = entityManager.createQuery(cq);
//
//    	return query.getSingleResult();
//	}

}
