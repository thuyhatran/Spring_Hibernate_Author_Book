/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this sessionFactory.getCurrentSession() file, choose Tools | Templates
 * and open the sessionFactory.getCurrentSession() in the editor.
 */
package implementDao;

import bean.Author;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/**
 *
 * @author thuyha
 */
@Service
public class AuthorDao {
    
    @Autowired 
   private SessionFactory sessionFactory;
   public void setSessionFactory(SessionFactory sessionFactory) {
      
        this.sessionFactory = sessionFactory;
    }

  
    //method to save 
    @Transactional
    public void saveAuthor(Author e){  
        Session session = sessionFactory.getCurrentSession();
        
        session.save(e);
    }  
    //method to update  
     @Transactional
    public void updateAuthor(Author e){  
        sessionFactory.getCurrentSession().update(e);  
    }  
    
    //method to delete employee  
     @Transactional
    public void deleteAuthor(Author e){  
        sessionFactory.getCurrentSession().delete(e);  
    }  
    //method to return one employee of given id  
     @Transactional
    public Author getById(int id){  
        Author e=(Author)sessionFactory.getCurrentSession().get(Author.class,id);  
        return e;  
    }  
    //method to return all employees  
     @Transactional
    public List<Author> getAuthors(){  
        List<Author> list=new ArrayList<Author>();  
        list=sessionFactory.getCurrentSession().createQuery("form Author").list();
        return list;  
    }  


    
}
