package com.gmail.andersoninfonet.jsfcomplete.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gmail.andersoninfonet.jsfcomplete.model.Grupo;
import com.gmail.andersoninfonet.jsfcomplete.model.Usuario;
import com.gmail.andersoninfonet.jsfcomplete.repository.UsuarioRepository;
import com.gmail.andersoninfonet.jsfcomplete.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
		
		UsuarioRepository usuarioRep = CDIServiceLocator.getBean(UsuarioRepository.class);
		Usuario usuario = usuarioRep.porEmail(email);	
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}
	
 	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}

	
}
