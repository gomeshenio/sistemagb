package sistemagb.domain.usuario;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sistemagb.domain.role.Role;

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

}
