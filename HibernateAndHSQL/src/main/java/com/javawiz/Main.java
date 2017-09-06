package com.javawiz;

import org.hibernate.Session;

import com.javawiz.model.Survey;
import com.javawiz.util.HibernateUtil;

public class Main {
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Survey survey = new Survey();
		survey.setName("Survey");
		System.out.println(survey.getId());

		session.save(survey);
		//session.flush();

		System.out.println(survey.getId());
		Survey surveyInSession = (Survey) session.get(Survey.class, survey.getId());
		System.out.println(surveyInSession.getName());

		session.close();
		HibernateUtil.shutdown();
	}
}
