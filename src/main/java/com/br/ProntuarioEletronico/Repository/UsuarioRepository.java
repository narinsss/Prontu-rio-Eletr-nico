package com.br.ProntuarioEletronico.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ProntuarioEletronico.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(@Param("user") String usuario);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param(" nome") String nome);
}
