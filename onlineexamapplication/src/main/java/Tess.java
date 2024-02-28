import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tka.dao.QuestionDAO;
import com.tka.entity.Question;
@Controller
public class Tess {
@Autowired
 static SessionFactory factory;
@Autowired
static QuestionDAO dao;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Session  session=factory.openSession();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter subject :- "); String subject=sc.next();
		List<Question>  list=dao.getAllQuestions(subject);
  	    Question   question =list.get(0);
  	 //   System.out.println(question);

	}

}
