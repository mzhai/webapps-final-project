package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import model.AnswerDAO;
import model.Model;
import model.UserDAO;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Answer;
import databeans.User;

import formbeans.AddAnswerForm;


public class AddAnswerAction extends Action{
	private FormBeanFactory<AddAnswerForm> formBeanFactory = FormBeanFactory.getInstance(AddAnswerForm.class);

	private AnswerDAO answerDAO;
	private UserDAO  userDAO;
	
	public AddAnswerAction(Model model) {
    	answerDAO = model.getAnswerDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "addAnswer.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			User user = (User) request.getSession(false).getAttribute("user");
        	Answer[] answerList = answerDAO.getAnswersWRTOnwer(user.getEmail());
        	if(answerList == null)
        		answerList = new Answer[] {};
	        request.setAttribute("answerList",answerList);

			AddAnswerForm form = formBeanFactory.create(request);
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) return "add-answer.jsp";

			Answer answer = new Answer();  // id & position will be set when created
			if (form.getContent().length() > 0) {
				answer.setContent(fixBadChars(form.getContent()));
			}
			answer.setContent(form.getContent());
			answer.setOwner(user.getEmail());
			answer.setQst(form.getQst());
			answerDAO.create(answer);

			// Update answerList (there's now one more on the list)
        	Answer[] newAnswerList = answerDAO.getAnswersWRTOnwer(user.getEmail());
	        request.setAttribute("answerList",newAnswerList);
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
