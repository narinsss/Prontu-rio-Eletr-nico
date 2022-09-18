package com.br.ProntuarioEletronico.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	@NotNull(message = "O atributo nome é obrigatório!")
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotBlank(message = "O Atributo sexo é obrigatório!")
	private String sexo;
	
	@Schema(example = "email@email.com")
	@NotNull(message = "O atributo usuario é obrigatório!")
	@Email(message = "O atributo usuario deve ser um email válido!")
	private String usuario;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres!")
	private String senha;
	
	@Size(max = 5000, message = "O ling da foto não pode ser maior do que 5000 caracteres!")
	private String foto;
	
	@NotBlank(message = "O Atributo CPF é obrigatório!")
	@CPF(message="cpf inválido")
	private String cpf;
	
	@NotBlank(message = "O atributo telefone é obrigatório!")
	private String telefone;
	
	@NotBlank(message = "O atributo conselho é obrigatória!")
	private String conselho;
	
	private String registro;
	private String uf;
	private String profissao;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Atendimento> atendimento;
	

	public Usuario(Long id, String tipo, String nome, String sexo, String usuario, String senha, String foto, String cpf, String telefone, String conselho, String registro, String uf,
			String profissao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.sexo = sexo;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.conselho = conselho;
		this.registro = registro;
		this.uf = uf;
		this.profissao = profissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Atendimento> getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}

}
