package sistemagb.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
    private Long id;
    private String username;
    private String login;
    private String password;
    private String email;
    private Boolean ativo;

}
