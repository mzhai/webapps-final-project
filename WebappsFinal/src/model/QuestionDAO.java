package model;

import java.util.Arrays;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.MatchArg;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.Question;

public class QuestionDAO {
	private BeanFactory<Question> factory;
	
	public QuestionDAO() throws DAOException {
		try {
	        // Get a BeanTable to create the "Question" table
	        BeanTable<Question> QuestionTable = BeanTable.getInstance(Question.class,"sizhel_Questions");
	        
	        if (!QuestionTable.exists()) QuestionTable.create("id");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        QuestionTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write
	        // rows of the "Question" table
	        factory = QuestionTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}

	public void create(Question newQuestion) throws DAOException {
		try {
			Transaction.begin();
			
			Question dbQuestion = factory.create();
			factory.copyInto(newQuestion,dbQuestion);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}

	public void delete(int id, String owner) throws DAOException {
		try {
			Transaction.begin();
    		Question b = factory.lookup(id);

    		if (b == null) {
				throw new DAOException("Question does not exist: id="+id);
    		}

    		if (!owner.equals(b.getOwner())) {
				throw new DAOException("Question not owned by "+owner);
    		}

			factory.delete(id);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public Question[] getQuestions(String owner) throws DAOException {
		try {
			Question[] list = factory.match(MatchArg.equals("owner",owner));
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public Question[] getAllQuestions() throws DAOException {
		try {
			Question[] list = factory.match();//get all
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	
	public Question lookup(int id) throws DAOException {
		try {
			return factory.lookup(id);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public void incrClicks(int id, String owner) throws DAOException{
		try{
			/*Question b = factory.lookup(id);
			b.incrClicks();
			factory.copyInto(b,factory.lookup(id));*/
			
	    	Question b = factory.lookup(id);
			int new_click = b.getClicks() + 1;
			delete(id, owner);
			b.setClicks(new_click);
			create(b);

		} catch (RollbackException e){
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
		
	}
	
}
