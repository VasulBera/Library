package org.library.dao;

public class DAOFactory {
    private BookDAO bookDAO = null;
    private InstanceDAO instanceDAO = null;
    private static DAOFactory instance = null;

    private DAOFactory() {
	bookDAO = new BookDAO();
	instanceDAO = new InstanceDAO();
    }
    
    public static DAOFactory getInstance(){
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public InstanceDAO getInstanceDAO() {
        return instanceDAO;
    }
    


}
