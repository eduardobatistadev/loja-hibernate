package com.loja.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.loja.enums.FormasDePgt;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int cliente_id;
	private int desconto;
	private Instant data;
	private FormasDePgt formas_pgt;

	@OneToMany(mappedBy = "ids.venda")
	private Set<ItensDaVenda> item = new HashSet<>();

	public Venda() {
		super();
	}

	public Venda(int cliente_id, int desconto, Instant data, FormasDePgt formas_pgt) {
		super();
		this.cliente_id = cliente_id;
		this.desconto = desconto;
		this.data = data;
		this.formas_pgt = formas_pgt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getDesconto() {
		return desconto;
	}
	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
	public Instant getData() {
		return data;
	}
	public void setData(Instant data) {
		this.data = data;
	}
	public FormasDePgt getFormas_pgt() {
		return formas_pgt;
	}
	public void setFormas_pgt(FormasDePgt formas_pgt) {
		this.formas_pgt = formas_pgt;
	}
	public Set<ItensDaVenda> getItem(){
		return item;
	}
	public Double getTotal() {
		double soma = 0;
		for (ItensDaVenda x : item) {
			soma = soma + x.getPreco_custo();
		}
		return soma;
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
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;

	}

	@Override
	public String toString() {

		return "Venda [id=" + id + ", cliente_id=" + cliente_id + ", desconto=" + desconto + ", data=" + data
				+ ", formas_pgt=" + formas_pgt + "]";

	}


}