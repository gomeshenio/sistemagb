package sistemagb.domain.role;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistemagb.domain.privilegio.Privilegio;
import sistemagb.domain.usuario.Usuario;

@Table(name = "roles")
@Entity(name = "Role")
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Collection<Usuario> usuarios;

	@ManyToMany
	@JoinTable(
			name = "roles_privilegios", 
			joinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "privilegio_id", referencedColumnName = "id"))
	private Collection<Privilegio> privilegios;

}
