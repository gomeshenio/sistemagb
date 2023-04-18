package sistemagb.modulos.uf;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistemagb.modulos.municipio.Municipio;

@Table(name = "unidades_federacao")
@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NamedQueries({ @NamedQuery(name = "findUFBySigla", query = "SELECT uf FROM UF uf WHERE uf.sigla = :sigla") })
public class UF {

    @Id
    @Column(name = "id_uf", nullable = false)
    private Integer id;
    
    @Column(name = "nome", nullable = true, length = 20)
    private String nome;
    
    @Column(name = "sigla", nullable = true, length = 2)
    private String sigla;
    
	public Set<Municipio> getMunicipios() {
		Set<Municipio> municipios = new HashSet<Municipio>();
		return municipios;
	}
	
}
