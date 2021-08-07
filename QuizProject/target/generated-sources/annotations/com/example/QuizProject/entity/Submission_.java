package com.example.QuizProject.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Submission.class)
public abstract class Submission_ {

	public static volatile SingularAttribute<Submission, Integer> submission_id;
	public static volatile SingularAttribute<Submission, Date> start_time;
	public static volatile SingularAttribute<Submission, Integer> score;
	public static volatile SingularAttribute<Submission, String> user_name;
	public static volatile SingularAttribute<Submission, Date> end_time;

	public static final String SUBMISSION_ID = "submission_id";
	public static final String START_TIME = "start_time";
	public static final String SCORE = "score";
	public static final String USER_NAME = "user_name";
	public static final String END_TIME = "end_time";

}

