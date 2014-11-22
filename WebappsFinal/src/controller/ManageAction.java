package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.AnswerDAO;
import model.Model;
import model.BookmarkDAO;
import model.QuestionDAO;
import model.UserDAO;

import org.mybeans.dao.DAOException;

import databeans.Bookmark;
import databeans.Question;
import databeans.User;


/*
 * Sets up the request attributes for manage.jsp.
 * This is the way to enter "Manage Your Photos"
 * from someplace else in the site.
 * 
 * Sets the "userList" request attribute in order to display
 * the list of users on the navbar.
 * 
 * Sets the "photoList" request attribute in order to display
 * the list of user's photos for management.
 * 
 * Forwards to manage.jsp.
 */
public class ManageAction extends Action {

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	private AnswerDAO	answerDAO;

	public ManageAction(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
    	answerDAO = model.getAnswerDAO();
	}

	public String getName() { return "manage.do"; }

	public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			User user = (User) request.getSession(false).getAttribute("user");
        	Question[] questionList = questionDAO.getQuestions(user.getEmail());
	        request.setAttribute("questionList",questionList);

	        return "manage.jsp";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}

