package sistemagb.modulos.municipio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistemagb.modulos.uf.UF;

@Table(name = "municipios")
@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Municipio {
	
	@Id
	@Column(name = "id_municipio", nullable = false)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@JoinColumn(name = "id_uf")
	@ManyToOne(fetch = FetchType.EAGER)
	private UF uf;
}
