package sistemagb.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sistemagb.jwt.usuario.DadosAutenticacao;
import sistemagb.jwt.usuario.Usuario;
import sistemagb.jwt.usuario.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(dados.username(), dados.password()));
        
        Usuario usuario = usuarioRepository.findByUsername(dados.username());
        
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT, usuario.getAuthorities()));
    }

}
