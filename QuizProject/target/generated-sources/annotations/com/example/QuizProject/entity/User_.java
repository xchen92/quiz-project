package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Boolean> is_admin;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> user_name;
	public static volatile SetAttribute<User, Submission> submissions;

	public static final String IS_ADMIN = "is_admin";
	public static final String PASSWORD = "password";
	public static final String USER_NAME = "user_name";
	public static final String SUBMISSIONS = "submissions";

}

