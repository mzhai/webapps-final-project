package model;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanTable;

public class Model {
    //private BookmarkDAO BookmarkDAO;
    private UserDAO  userDAO;
    private QuestionDAO questionDAO;
    private AnswerDAO answerDAO;

    public Model(ServletConfig config) throws ServletException {
	try {
	    String csvDirStr = config.getInitParameter("csvDir");
	    if (csvDirStr != null && csvDirStr.length() > 0) {
		File csvDir = new File(csvDirStr);
		BeanTable.useCSVFiles(csvDir);
	    } else {
		String jdbcDriver   = config.getInitParameter("jdbcDriverName");
		String jdbcURL      = config.getInitParameter("jdbcURL");
		String jdbcUser     = config.getInitParameter("jdbcUser");
		String jdbcPassword = config.getInitParameter("jdbcPassword");
		BeanTable.useJDBC(jdbcDriver,jdbcURL,jdbcUser,jdbcPassword);
	    }
			
	    userDAO  = new UserDAO();
	    questionDAO = new QuestionDAO();
	    answerDAO = new AnswerDAO();
	    //BookmarkDAO = new BookmarkDAO();
	} catch (DAOException e) {
	    throw new ServletException(e);
	}
    }
	
    //public BookmarkDAO getBookmarkDAO() { return BookmarkDAO; }
    public QuestionDAO getQuestionDAO() {return questionDAO;}
    public AnswerDAO getAnswerDAO() {return answerDAO;}
    public UserDAO  getUserDAO()  { return userDAO;  }
}