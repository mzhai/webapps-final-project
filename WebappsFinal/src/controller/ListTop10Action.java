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
public class ListTop10Action extends Action {

	private QuestionDAO questionDAO;
	private UserDAO  userDAO;
	private AnswerDAO	answerDAO;

    public ListTop10Action(Model model) {
    	questionDAO = model.getQuestionDAO();
    	userDAO  = model.getUserDAO();
    	answerDAO = model.getAnswerDAO();
	}

    public String getName() { return "top10questions.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the request attributes (the errors list and the form bean so
        // we can just return to the jsp with the form if the request isn't correct)
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			Question[] questionList = questionDAO.getAllQuestions();
			
			// keep top 10 if more than 10 bookmarks
			if(questionList.length > 10){
				Question[] tempList = new Question[10];
				for(int i =0; i< 10;i++){
					tempList[i] = questionList[questionList.length-i-1];
				}
				questionList = tempList;
			}else{
				Question[] templist = new Question[questionList.length];
				for(int i=0; i< questionList.length;i++){
					templist[i] = questionList[questionList.length-i-1];
				}
				questionList = templist;
			}
			
	        request.setAttribute("questionList",questionList);

	        return "listall.jsp";
        } catch (DAOException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } 
    }
}

