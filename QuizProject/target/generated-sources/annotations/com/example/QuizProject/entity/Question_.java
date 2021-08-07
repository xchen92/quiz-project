package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Question.class)
public abstract class Question_ {

	public static volatile SingularAttribute<Question, String> question_text;
	public static volatile SingularAttribute<Question, Integer> question_id;
	public static volatile SingularAttribute<Question, Integer> answer_id;

	public static final String QUESTION_TEXT = "question_text";
	public static final String QUESTION_ID = "question_id";
	public static final String ANSWER_ID = "answer_id";

}

