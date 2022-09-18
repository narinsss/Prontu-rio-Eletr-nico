package com.br.ProntuarioEletronico.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.br.ProntuarioEletronico.Repository.UsuarioRepository;
import com.br.ProntuarioEletronico.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);
		
		if(usuario.isPresent()) {
			return new UserDetailsImpl(usuario.get());
		}else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
