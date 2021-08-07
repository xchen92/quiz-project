package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Option.class)
public abstract class Option_ {

	public static volatile SingularAttribute<Option, String> option_text;
	public static volatile SingularAttribute<Option, Integer> option_id;
	public static volatile SingularAttribute<Option, Integer> question_id;

	public static final String OPTION_TEXT = "option_text";
	public static final String OPTION_ID = "option_id";
	public static final String QUESTION_ID = "question_id";

}

