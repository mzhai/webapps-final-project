package model;

import java.util.Arrays;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.MatchArg;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.Answer;


public class AnswerDAO {
	private BeanFactory<Answer> factory;
	
	public AnswerDAO() throws DAOException {
		try {
	        // Get a BeanTable to create the "Answer" table
	        BeanTable<Answer> AnswerTable = BeanTable.getInstance(Answer.class,"sizhel_Answers");
	        
	        if (!AnswerTable.exists()) AnswerTable.create("id");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        AnswerTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write
	        // rows of the "Answer" table
	        factory = AnswerTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}

	public void create(Answer newAnswer) throws DAOException {
		try {
			Transaction.begin();
			
			Answer dbAnswer = factory.create();
			factory.copyInto(newAnswer,dbAnswer);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}

	public void delete(int id, String owner, String qst) throws DAOException {
		try {
			Transaction.begin();
    		Answer b = factory.lookup(id);

    		if (b == null) {
				throw new DAOException("Answer does not exist: id="+id);
    		}

    		if (!owner.equals(b.getOwner())) {
				throw new DAOException("Answer not owned by "+owner);
    		}
    		
    		if (!qst.equals(b.getQst())) {
    			throw new DAOException("Answer not belongs to "+qst);
    		}

			factory.delete(id);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public Answer[] getAnswersWRTOnwer(String owner) throws DAOException {
		try {
			Answer[] list = factory.match(MatchArg.equals("owner",owner));
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public Answer[] getAnswersWRTQst(String qst) throws DAOException {
		try {
			Answer[] list = factory.match(MatchArg.equals("qst",qst));
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public Answer[] getAllAnswers() throws DAOException {
		try {
			Answer[] list = factory.match();//get all
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	
	public Answer lookup(int id) throws DAOException {
		try {
			return factory.lookup(id);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public void incrClicks(int id, String owner, String qst) throws DAOException{
		try{
			/*Answer b = factory.lookup(id);
			b.incrClicks();
			factory.copyInto(b,factory.lookup(id));*/
			
	    	Answer b = factory.lookup(id);
			int new_click = b.getClicks() + 1;
			delete(id, owner, qst);
			b.setClicks(new_click);
			create(b);

		} catch (RollbackException e){
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
		
	}
	
}
