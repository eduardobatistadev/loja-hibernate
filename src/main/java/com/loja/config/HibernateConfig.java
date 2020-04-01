package com.loja.config;

import java.util.Properties
;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.loja.model.Fornecedor;
import com.loja.model.FornecedorProduto;
import com.loja.model.ItensDaVenda;
import com.loja.model.Produto;
import com.loja.model.Venda;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties prop = new Properties();
				
				// Banco de Dados
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/loja-hibernate?useSSL=false");
				prop.put(Environment.USER, "qintess");
				prop.put(Environment.PASS, "123456");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				prop.put(Environment.SHOW_SQL, "true"); // em ambiente produtivo é false
				prop.put(Environment.HBM2DDL_AUTO, "update"); // em ambiente produtivo nunca utilizar create ou create-drop
				
				configuration.setProperties(prop);
				configuration.addAnnotatedClass(Fornecedor.class);
				configuration.addAnnotatedClass(FornecedorProduto.class);
				configuration.addAnnotatedClass(ItensDaVenda.class);
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
				
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	// retorna a chave primaria
	public static Object getPrimaryKey(Object entidade) {
		return sessionFactory.getPersistenceUnitUtil().getIdentifier(entidade);
	}

}
