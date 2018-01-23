package com.myprogram.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 自定义一个Hibernate工具类用来
 * 生产Hibernate会话Session对象
 * @author Administrator
 *
 */
public class HibernateUtil {

	//声明一个静态会话工厂
	private static SessionFactory sessionFactory;
	
	//加载时构建静态会话工厂对象[不同版本，方式不同]
	static{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	/*
	 *hibernate4构建方式
	 static{
		//构建一个配置文件对象，读取到hiberante.cfg.xml
		Configuration conf=new Configuration().configure();
		//hibernate4开始，需要指定安全策略
		ServiceRegistry sr=
			    new StandardServiceRegistryBuilder().build();
		sessionFactory=conf.buildSessionFactory(sr);
	}
	 */
	
	//获取一个会话
	//3.0版本sessionFactory.openSession();
	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
		System.out.println(getSession());
	}
}



