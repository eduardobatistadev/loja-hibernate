package com.loja.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.loja.model.pk.VendaItemPK;

@Entity
public class ItensDaVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@EmbeddedId
	private VendaItemPK ids = new VendaItemPK();
	private int quantidade;
	private double preco_custo;
	private double preco_unit;
	
	public ItensDaVenda() {
		super();
	}
	public ItensDaVenda(Venda venda, Produto produto ,int id, int quantidade, double preco_custo, double preco_unit) {
		super();
		ids.setVenda(venda);
		ids.setProduto(produto);
		this.id = id;
		this.quantidade = quantidade;
		this.preco_custo = preco_custo;
		this.preco_unit = preco_unit;
	}
	public Venda getVenda() {
		return ids.getVenda();
	}
	public void setVenda(Venda venda) {
		ids.setVenda(venda);
	}
	public Produto getProduto() {
		return ids.getProduto();
	}
	public void setProduto(Produto produto) {
		ids.setProduto(produto);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getPreco_custo() {
		return preco_custo;
	}


	public void setPreco_custo(double preco_custo) {
		this.preco_custo = preco_custo;
	}


	public double getPreco_unit() {
		return preco_unit;
	}


	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ids == null) ? 0 : ids.hashCode());
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
		ItensDaVenda other = (ItensDaVenda) obj;
		if (ids == null) {
			if (other.ids != null)
				return false;
		} else if (!ids.equals(other.ids))
			return false;
		return true;
	}
	
	
	
	
}
