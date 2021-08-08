package com.example.QuizProject.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuestionAnswer.class)
public abstract class QuestionAnswer_ {

	public static volatile SingularAttribute<QuestionAnswer, Submission> submission;
	public static volatile SingularAttribute<QuestionAnswer, Integer> question_answer_id;
	public static volatile SingularAttribute<QuestionAnswer, Integer> question_id;
	public static volatile SingularAttribute<QuestionAnswer, Integer> answer_id;

	public static final String SUBMISSION = "submission";
	public static final String QUESTION_ANSWER_ID = "question_answer_id";
	public static final String QUESTION_ID = "question_id";
	public static final String ANSWER_ID = "answer_id";

}

