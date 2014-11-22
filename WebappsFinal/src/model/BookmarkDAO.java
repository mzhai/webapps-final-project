package model;

import java.util.Arrays;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.MatchArg;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.Bookmark;


public class BookmarkDAO {
	private BeanFactory<Bookmark> factory;
	
	public BookmarkDAO() throws DAOException {
		try {
	        // Get a BeanTable to create the "Bookmark" table
	        BeanTable<Bookmark> BookmarkTable = BeanTable.getInstance(Bookmark.class,"sizhel_Bookmarks");
	        
	        if (!BookmarkTable.exists()) BookmarkTable.create("id");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        BookmarkTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write
	        // rows of the "Bookmark" table
	        factory = BookmarkTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}

	public void create(Bookmark newBookmark) throws DAOException {
		try {
			Transaction.begin();
			
			Bookmark dbBookmark = factory.create();
			factory.copyInto(newBookmark,dbBookmark);
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
    		Bookmark b = factory.lookup(id);

    		if (b == null) {
				throw new DAOException("Bookmark does not exist: id="+id);
    		}

    		if (!owner.equals(b.getOwner())) {
				throw new DAOException("Bookmark not owned by "+owner);
    		}

			factory.delete(id);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public Bookmark[] getBookmarks(String owner) throws DAOException {
		try {
			Bookmark[] list = factory.match(MatchArg.equals("owner",owner));
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public Bookmark[] getAllBookmarks() throws DAOException {
		try {
			Bookmark[] list = factory.match();//get all
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	
	public Bookmark lookup(int id) throws DAOException {
		try {
			return factory.lookup(id);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public void incrClicks(int id, String owner) throws DAOException{
		try{
			/*Bookmark b = factory.lookup(id);
			b.incrClicks();
			factory.copyInto(b,factory.lookup(id));*/
			
	    	Bookmark b = factory.lookup(id);
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
