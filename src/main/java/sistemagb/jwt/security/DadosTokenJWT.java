package sistemagb.jwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public record DadosTokenJWT(String token, Collection<? extends GrantedAuthority> authorities) {
}
