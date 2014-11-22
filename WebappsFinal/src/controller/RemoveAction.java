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

import databeans.Answer;
import databeans.Bookmark;
import databeans.Question;
import databeans.User;

/*
 * Removes a photo.  Given an "id" parameter.
 * Checks to see that id is valid number for a photo and that
 * the logged user is the owner.
 * 
 * Sets up the "userList" and "photoList" request attributes
 * and if successful, forwards back to to "manage.jsp".
 */
public class RemoveAction extends Action {

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	private AnswerDAO	answerDAO;

    public RemoveAction(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
    	answerDAO = model.getAnswerDAO();
	}

    public String getName() { return "remove.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());
	    	
	    	User user = (User) request.getSession().getAttribute("user");

	    	if(request.getParameter("qid") != null){
	    		int qid = Integer.parseInt(request.getParameter("qid"));
	    		questionDAO.delete(qid,user.getEmail());
	    		
	    		// Be sure to get the List after the delete
	        	Question[] questionList = questionDAO.getQuestions(user.getEmail());
		        request.setAttribute("questionList",questionList);
	    	}
	    	
	    	if(request.getParameter("aid") != null){
	    		int aid = Integer.parseInt(request.getParameter("aid"));
	    		answerDAO.delete(aid,user.getEmail(),answerDAO.lookup(aid).getQst());
	    		
	    		// Be sure to get the List after the delete
	        	Answer[] answerList = answerDAO.getAnswersWRTOnwer(user.getEmail());
		        request.setAttribute("questionList",answerList);
	    	}
	    	
	        return "manage.jsp";
		} catch (DAOException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
		}
    }
}