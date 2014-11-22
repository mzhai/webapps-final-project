package controller;
import javax.servlet.http.HttpServletRequest;

import org.mybeans.dao.DAOException;

import databeans.Bookmark;
import databeans.Question;
import databeans.User;
import model.Model;

import model.AnswerDAO;
import model.BookmarkDAO;
import model.QuestionDAO;
import model.UserDAO;




public class RedirectAction extends Action {

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	private AnswerDAO	answerDAO;
	
	public RedirectAction(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
    	answerDAO = model.getAnswerDAO();
	}

 	public String getName() { return "redirect.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the errors list
		try {
            // Set up user list for nav bar
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = (User) request.getSession(false).getAttribute("user");
		Question question = questionDAO.lookup(id);
		if (!(user.getEmail().equals(question.getOwner()))) {
		    questionDAO.incrClicks(question.getId(),question.getOwner());
		}
        	    return question.getTitle();
		} catch (DAOException e) {
		    	return "manage.jsp";
		}
    }
    
 }