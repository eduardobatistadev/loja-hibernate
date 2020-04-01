package com.loja.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.loja.model.Fornecedor;
import com.loja.model.Produto;

@Embeddable
public class FornecedorProdutoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		FornecedorProdutoPK other = (FornecedorProdutoPK) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
	

}
