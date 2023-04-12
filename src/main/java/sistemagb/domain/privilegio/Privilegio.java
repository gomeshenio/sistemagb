package sistemagb.domain.privilegio;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistemagb.domain.role.Role;

@Table(name = "privilegios")
@Entity(name = "Privilegio")
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Privilegio {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String nome;

    @ManyToMany(mappedBy = "privilegios")
    @JsonIgnore
    private Collection<Role> roles;

}
