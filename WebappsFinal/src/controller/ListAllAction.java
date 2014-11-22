package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.AnswerDAO;
import model.Model;
import model.QuestionDAO;
import model.UserDAO;

import org.mybeans.dao.DAOException;

import databeans.Question;


/*
 * Looks up the photos for a given "user".
 * 
 * If successful:
 *   (1) Sets the "userList" request attribute in order to display
 *       the list of users on the navbar.
 *   (2) Sets the "photoList" request attribute in order to display
 *       the list of given user's photos for selection.
 *   (3) Forwards to list.jsp.
 */
public class ListAllAction extends Action {

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	private AnswerDAO	answerDAO;

    public ListAllAction(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
    	answerDAO = model.getAnswerDAO();
	}

    public String getName() { return "allquestions.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the request attributes (the errors list and the form bean so
        // we can just return to the jsp with the form if the request isn't correct)
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			Question[] questionList = questionDAO.getAllQuestions();
	        request.setAttribute("questionList",questionList);

	        return "listall.jsp";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } 
    }
}

