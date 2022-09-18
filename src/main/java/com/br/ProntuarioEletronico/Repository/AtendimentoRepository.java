package com.br.ProntuarioEletronico.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.ProntuarioEletronico.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
	public List<Atendimento> findAllByQueixaContainingIgnoreCase (@Param("queixa") String queixa);
}
