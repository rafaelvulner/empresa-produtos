package com.produto.api.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.produto.api.entities.Usuario;
import com.produto.api.service.UsuarioService;
import com.produto.api.utils.PasswordUtils;

@Component
public class AuthProviderService implements AuthenticationProvider {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String user = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		Optional<Usuario> usuario = usuarioService.findByUsuario(user);
		
		if(usuario.isPresent()) {
			if (PasswordUtils.comparePassword(password, usuario.get().getSenha())) {

				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
				
			} else {
				throw new BadCredentialsException("External system authentication failed");
			}
		}
		
		throw new BadCredentialsException("External system authentication failed");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
