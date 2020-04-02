package com.loja;

import java.time.Instant;

import com.loja.dao.DaoGeneric;
import com.loja.enums.FormasDePgt;
import com.loja.model.Fornecedor;
import com.loja.model.Produto;
import com.loja.model.Venda;

public class App {
	
	public static void main(String[] args) {
		
		//	buscar e atualizar produto
		DaoGeneric<Produto> daoProduto = new DaoGeneric<Produto>();
		Produto p1 = new Produto();
		// buscar id
		p1.setId(2);
		p1 = daoProduto.buscarId(p1);
		System.out.println(p1);
		// atualizar
		p1.setFoto("www.loja.com.foto.memoriaram4gb");
		daoProduto.atualizar(p1);
		
		
		// inserção da Venda
		DaoGeneric<Venda> daoVenda = new DaoGeneric<Venda>();
		Venda v1 = new Venda(1, 0, Instant.parse("2019-09-23T12:25:04Z"), FormasDePgt.CARTAO_DEBITO);
		daoVenda.salvar(v1);
		
		//inserção de fornecedor
		DaoGeneric<Fornecedor> daoForn = new DaoGeneric<Fornecedor>();
		Fornecedor f1 = new Fornecedor("Caetano", "(11)98711-3305", "(11)98394-9393");
		daoForn.salvar(f1);
		
		//deletar
		Fornecedor forn = new Fornecedor();
		forn.setId(8);
		forn = daoForn.buscarId(forn);
		daoForn.deletar(forn);

	
	}
}

