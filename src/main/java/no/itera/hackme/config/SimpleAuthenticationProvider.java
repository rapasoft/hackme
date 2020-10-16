package no.itera.hackme.config;

import no.itera.hackme.service.LoginService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    private final LoginService loginService;

    public SimpleAuthenticationProvider(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var name = authentication.getName();
        var password = authentication.getCredentials().toString();

        var user = loginService.performLogin(name, password);
        return new UsernamePasswordAuthenticationToken(name, password, List.of(
                new SimpleGrantedAuthority(user.getRole())
        ));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
