package com.loja;

import com.loja.dao.DaoGeneric;
import com.loja.model.ItensDaVenda;
import com.loja.model.Venda;

public class App {
	
	public static void main(String[] args) {
	
		
		DaoGeneric<ItensDaVenda> daoGeneric = new DaoGeneric<ItensDaVenda>();
		ItensDaVenda item1 = new ItensDaVenda(, 2 , 1, 100.00, 100.00);
		daoGeneric.salvar(item1);
		
		
		
		// buscar e atualizar produto
//		DaoGeneric<Produto> daoGeneric = new DaoGeneric<Produto>();
//		Produto p1 = new Produto();
//		// buscar id
//		p1.setId(2);
//		p1 = daoGeneric.buscarId(p1);
//		System.out.println(p1);
//		// atualizar
//		p1.setFoto("www.loja.com.foto.memoriaram4gb");
//		daoGeneric.atualizar(p1);
		
		
		//========= busca generica por id ==================
//		Cliente cliente = new Cliente();
//		cliente.setIdcliente(2L);
//		cliente = daoGeneric.buscarId(cliente);
//		System.out.println(cliente);
		
		//========== busca generica de todos ===============
//		List<Cliente> list = daoGeneric.BuscarTodos(Cliente.class);
//		for (Cliente cliente : list) {
//			System.out.println(cliente);
//		}
	// ===========atualização generica============ para atualizar é preciso buscar o id conforme acima
//		cliente.setNome("Pedro Ferreira do nascimento");
//		cliente = daoGeneric.atualizar(cliente);
//		System.out.println(cliente);
		
		// ======== deletar por id ==============
//		Cliente cliente = new Cliente();
//		cliente.setIdcliente(3L);
//		cliente = daoGeneric.buscarId(cliente);
//		daoGeneric.deletar(cliente);
		
		// ========== Buscar todos Clientes ===============
//		DaoCliente cliente1 = new DaoCliente();
//		cliente1.findAll().forEach(s -> System.out.println(s));
	
	}
}

