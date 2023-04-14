package sistemagb.jwt.usuario;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sistemagb.jwt.role.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
    private Long id;
    private String username;
    private String nome;
    private String password;
    private String email;
    private Boolean ativo;
    
    private Set<Role> roles;

	public UsuarioDTO(Long id, String username, String nome, String email, Boolean ativo) {
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.ativo = ativo;
	}
    
    

}
