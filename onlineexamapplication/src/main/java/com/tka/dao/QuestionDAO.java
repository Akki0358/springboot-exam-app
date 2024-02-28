package com.tka.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tka.entity.Question;
@Repository
public class QuestionDAO {

@Autowired
 SessionFactory factory;

@RequestMapping("getAllQuestions")		
public  List<Question> getAllQuestions(String subject)
	{
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Question.class);
		// question (qno) & Subject(java,gk) both are primary key
		criteria.add(Restrictions.eq("subject",subject));
			
		return criteria.list();
	}


}






