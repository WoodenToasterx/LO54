package fr.utbm.course.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, String> firstname;
	public static volatile SingularAttribute<Client, CourseSession> courseSession;
	public static volatile SingularAttribute<Client, String> address;
	public static volatile SingularAttribute<Client, String> phone;
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, String> email;
	public static volatile SingularAttribute<Client, String> lastname;

}

