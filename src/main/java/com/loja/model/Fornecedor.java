
package com.loja.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	private String nome;

	private String telefone;

	private String contato;

	

	@OneToMany(mappedBy = "id.fornecedor")

	private Set<FornecedorProduto> items = new HashSet<>();

	

	public Fornecedor() {

		super();

	}

	

	public Fornecedor(String nome, String telefone, String contato) {

		super();

		this.nome = nome;

		this.telefone = telefone;

		this.contato = contato;
	}



	public int getId() {

		return id;

	}



	public void setId(int id) {

		this.id = id;

	}



	public String getNome() {

		return nome;

	}



	public void setNome(String nome) {

		this.nome = nome;

	}



	public String getTelefone() {

		return telefone;

	}



	public void setTelefone(String telefone) {

		this.telefone = telefone;

	}



	public String getContato() {

		return contato;

	}



	public void setContato(String contato) {

		this.contato = contato;

	}

	public Set<FornecedorProduto> getItem(){

		return items;

	}



	@Override

	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + id;

		return result;

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Fornecedor other = (Fornecedor) obj;

		if (id != other.id)

			return false;

		return true;

	}



	

	



	

	

	



}