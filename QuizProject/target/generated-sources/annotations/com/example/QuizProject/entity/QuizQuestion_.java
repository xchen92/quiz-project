package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuizQuestion.class)
public abstract class QuizQuestion_ {

	public static volatile SingularAttribute<QuizQuestion, Integer> quiz_id;
	public static volatile SingularAttribute<QuizQuestion, Integer> quiz_question_id;
	public static volatile SingularAttribute<QuizQuestion, Integer> question_id;

	public static final String QUIZ_ID = "quiz_id";
	public static final String QUIZ_QUESTION_ID = "quiz_question_id";
	public static final String QUESTION_ID = "question_id";

}

