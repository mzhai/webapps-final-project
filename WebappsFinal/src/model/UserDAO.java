package model;

import java.util.Arrays;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.DuplicateKeyException;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.User;



public class UserDAO {
	private BeanFactory<User> factory;
	
	public UserDAO() throws DAOException {
		try {
			// Get a BeanTable so we can create the "users" table
	        BeanTable<User> userTable = BeanTable.getInstance(User.class,"sizhel_users1");
	        
	        if (!userTable.exists()) userTable.create("email");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        userTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write rows of the "user" table
	        factory = userTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}
	
	public void create(User user) throws DAOException {
        try {
        	Transaction.begin();
			User dbUser = factory.create(user.getEmail());
			factory.copyInto(user,dbUser);
			Transaction.commit();
		} catch (DuplicateKeyException e) {
			throw new DAOException("A user with email "+user.getEmail()+" already exists");
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public User lookup(String email) throws DAOException {
		try {
			return factory.lookup(email);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	protected BeanFactory<User> getFactory() { return factory; }
	
	public User[] getUsers() throws DAOException {
		try {
			User[] users = factory.match();
			Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
			return users;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public void setPassword(String email, String password) throws DAOException {
        try {
        	Transaction.begin();
			User dbUser = factory.lookup(email);
			
			if (dbUser == null) {
				throw new DAOException("User "+email+" no longer exists");
			}
			
			dbUser.setPassword(password);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
}

