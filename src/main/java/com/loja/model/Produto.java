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

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private double preco_venda;
	private int min_etoque;
	private String nome;
	private String foto;

	

	@OneToMany(mappedBy = "ids.produto")
	private Set<ItensDaVenda> item = new HashSet<>();

	

	@OneToMany(mappedBy = "id.produto")
	private Set<FornecedorProduto> items = new HashSet<>();

	public Produto() {

		super();

	}
	public Produto(double preco_venda, int min_etoque, String nome, String foto) {

		super();

		this.preco_venda = preco_venda;
		this.min_etoque = min_etoque;
		this.nome = nome;
		this.foto = foto;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getMin_etoque() {
		return min_etoque;
	}

	public void setMin_etoque(int min_etoque) {
		this.min_etoque = min_etoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Set<Venda> getVendas(){

		Set<Venda> set = new HashSet<>();
		// percorrer cada  objeto do tipo ItensDaVenda x, contido na lista item, 
		//percorrendo a coleção do tipo ItensDaVenda associoado ao meu produto
		// para cada elemento da coleção add ao conjunto o x.getvenda
		for (ItensDaVenda x : item) {
			set.add(x.getVenda());
		}
		return set;
	}

	public Set<Fornecedor> getFornecedores(){
		Set<Fornecedor> set = new HashSet<>();
		for (FornecedorProduto x : items) {
			set.add(x.getFornecedor());
		}
		return set;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", preco_venda=" + preco_venda + ", min_etoque=" + min_etoque + ", nome=" + nome
				+ ", foto=" + foto + "]";

	}
}