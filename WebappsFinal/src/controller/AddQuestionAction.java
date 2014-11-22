package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Question;
import databeans.User;
import formbeans.AddQuestionForm;
import model.QuestionDAO;
import model.Model;
import model.UserDAO;

public class AddQuestionAction extends Action {
	private FormBeanFactory<AddQuestionForm> formBeanFactory = FormBeanFactory.getInstance(AddQuestionForm.class);

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	
	public AddQuestionAction(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "addQuestion.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			User user = (User) request.getSession(false).getAttribute("user");
        	Question[] questionList = questionDAO.getQuestions(user.getEmail());
        	if(questionList == null)
        		questionList = new Question[] {};
	        request.setAttribute("questionList",questionList);

			AddQuestionForm form = formBeanFactory.create(request);
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) return "add-question.jsp";

			Question question = new Question();  // id & position will be set when created
			if (form.getContent().length() > 0) {
				question.setContent(fixBadChars(form.getContent()));
			}
			question.setTitle(form.getTitle());
			question.setCatagory(form.getCatagory());
			question.setCompany(form.getCompany());
			question.setContent(form.getContent());
			question.setLanguage(form.getLanguage());
			question.setOwner(user.getEmail());
			questionDAO.create(question);

			// Update questionList (there's now one more on the list)
        	Question[] newQuestionList = questionDAO.getQuestions(user.getEmail());
	        request.setAttribute("questionList",newQuestionList);
	        return "manage.jsp";
	 	} catch (DAOException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
	 	} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
		}
    }
    
    private String fixBadChars(String s) {
		if (s == null || s.length() == 0) return s;
		
		Pattern p = Pattern.compile("[<>\"&]");
        Matcher m = p.matcher(s);
        StringBuffer b = null;
        while (m.find()) {
            if (b == null) b = new StringBuffer();
            switch (s.charAt(m.start())) {
                case '<':  m.appendReplacement(b,"&lt;");
                           break;
                case '>':  m.appendReplacement(b,"&gt;");
                           break;
                case '&':  m.appendReplacement(b,"&amp;");
                		   break;
                case '"':  m.appendReplacement(b,"&quot;");
                           break;
                default:   m.appendReplacement(b,"&#"+((int)s.charAt(m.start()))+';');
            }
        }
        
        if (b == null) return s;
        m.appendTail(b);
        return b.toString();
    }
}
