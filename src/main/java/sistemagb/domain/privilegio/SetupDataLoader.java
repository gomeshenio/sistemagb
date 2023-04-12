package sistemagb.domain.privilegio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.transaction.Transactional;
import sistemagb.domain.usuario.Usuario;
import sistemagb.domain.usuario.UsuarioRepository;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

    @Autowired
    private UsuarioRepository userRepository;
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Autowired
    private PrivilegioRepository privilegioRepository;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
 
        if (alreadySetup)
            return;
        Privilegio readPrivilegio = createPrivilegioIfNotFound("READ_PRIVILEGIO");
        Privilegio writePrivilegio = createPrivilegioIfNotFound("WRITE_PRIVILEGIO");
 
        List<Privilegio> adminPrivileges = Arrays.asList(
          readPrivilegio, writePrivilegio);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilegio));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Usuario usuario = new Usuario();
        usuario.setNome("Test");
        usuario.setLogin("Test");
        usuario.setSenha(passwordEncoder.encode("test"));
        usuario.setEmail("test@test.com");
        usuario.setRoles(Arrays.asList(adminRole));
        usuario.setAtivo(true);
        userRepository.save(usuario);

        alreadySetup = true;
    }

    @Transactional
    Privilegio createPrivilegioIfNotFound(String nome) {
 
        Privilegio privilegio = privilegioRepository.findByName(nome);
        if (privilegio == null) {
        	privilegio = new Privilegio(null, nome, null);
            privilegioRepository.save(privilegio);
        }
        return privilegio;
    }

    @Transactional
    Role createRoleIfNotFound(
      String nome, Collection<Privilegio> privilegios) {
 
        Role role = roleRepository.findByName(nome);
        if (role == null) {
            role = new Role(nome, null);
            role.setPrivilegios(get privilegios);
            roleRepository.save(role);
        }
        return role;
    }
  
}
