package com.br.ProntuarioEletronico.model;

import java.time.LocalDate;
import java.util.Date;
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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Atributo nome é obrigatório!")
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotBlank(message = "O Atributo data de nascimento é obrigatório!")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "O Atributo naturalidade é obrigatório!")
	private String naturalidade;
	
	@NotBlank(message = "O Atributo sexo é obrigatório!")
	private String sexo;
	
	@NotBlank(message = "O estado civil é obrigatório!")
	private String estadoCivil;
	
	@NotBlank(message = "O Atributo CPF é obrigatório!")
	@CPF(message="cpf inválido")
	private String cpf;
	
	@NotBlank(message = "O Atributo RG é obrigatório!")
	private String rg;
	
	@NotBlank(message = "O Atributo emissor é obrigatório!")
	private String emissor;
	
	@Size(max = 5000, message = "O ling da foto não pode ser maior do que 5000 caracteres!")
	private String foto;
	
	@Schema(example = "email@email.com")
	@NotNull(message = "O atributo email é obrigatório!")
	@Email(message = "O atributo email deve ser um email válido!")
	private String email;
	
	@NotBlank(message = "O atributo telefone é obrigatório!")
	private String telefone;
	
	@NotNull(message = "O atributo convênio é obrigatório!")
	private String convenio;
	
	@NotBlank(message = "O atributo carteira é obrigatório!")
	private String carteira;
	
	@NotNull(message = "O atributo plano é obrigatório!")
	private String plano;
	
	@NotBlank(message = "O atributo validade é obrigatório!")
	private Date validade;
	
	@NotBlank(message = "O atributo cep é obrigatório!")
	private String cep;
	
	@NotNull(message = "O atributo endereço é obrigatório!")
	private String endereco;
	
	@NotNull(message = "O atributo bairro é obrigatório!")
	private String bairro;
	
	@NotNull(message = "O atributo estado é obrigatório!")
	private String estado;
	
	@NotNull(message = "O atributo cidade é obrigatório!")
	private String cidade;
	
	@NotNull(message = "O atributo número é obrigatório!")
	private String numero;
	private String complemento;
	private String tipo;
	
	@NotBlank(message = "O atributo peso é obrigatório!")
	private float peso;
	
	@NotBlank(message = "O atributo altura é obrigatório!")
	private float altura;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("paciente")
	private List<Atendimento> atendimento;
	
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public List<Atendimento> getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
	}

}
