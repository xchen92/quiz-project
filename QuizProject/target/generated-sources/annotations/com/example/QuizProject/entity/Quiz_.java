package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Quiz.class)
public abstract class Quiz_ {

	public static volatile SingularAttribute<Quiz, Integer> quiz_id;
	public static volatile SingularAttribute<Quiz, String> quiz_img;
	public static volatile ListAttribute<Quiz, Question> questions;
	public static volatile SingularAttribute<Quiz, String> quiz_name;

	public static final String QUIZ_ID = "quiz_id";
	public static final String QUIZ_IMG = "quiz_img";
	public static final String QUESTIONS = "questions";
	public static final String QUIZ_NAME = "quiz_name";

}

