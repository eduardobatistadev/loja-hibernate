package com.loja.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.loja.model.pk.FornecedorProdutoPK;

@Entity
public class FornecedorProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private FornecedorProdutoPK id = new FornecedorProdutoPK();
	private int estoque;
	private double preco_custo;

	public FornecedorProduto() {
		super();
	}

	public FornecedorProduto(Fornecedor fornecedor, Produto produto,int estoque, double preco_custo) {
		super();
		id.setFornecedor(fornecedor);
		id.setProduto(produto);
		this.estoque = estoque;
		this.preco_custo = preco_custo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}
	
	public Fornecedor getFornecedor() {
		return id.getFornecedor();
	}
	public void SetFornecedor(Fornecedor fornecedor) {
		id.setFornecedor(fornecedor);
	} 
	public Produto getProduto() {
		return id.getProduto();
	}
	public void SetProduto(Produto produto) {
		id.setProduto(produto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FornecedorProduto other = (FornecedorProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
