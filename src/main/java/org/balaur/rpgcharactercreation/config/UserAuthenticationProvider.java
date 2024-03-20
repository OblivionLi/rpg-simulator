package org.balaur.rpgcharactercreation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO: Implement your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO: Return true if this AuthenticationProvider supports the passed Authentication object
        return false;
    }
}
