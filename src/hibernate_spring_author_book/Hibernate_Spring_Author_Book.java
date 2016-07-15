/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_spring_author_book;

import bean.Author;
import bean.Book;
import implementDao.AuthorDao;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author thuyha
 */
public class Hibernate_Spring_Author_Book {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
             
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	//AuthorDao authorDAO = context.getBean("authorDao",AuthorDao.class);
        AuthorDao authorDAO = context.getBean(AuthorDao.class);
		
         // create a Book entity
        
        Author author1 = new Author();
        author1.setName("Hernest Hemingway");
        author1.setEmail("HernestHemingway@hotmail.com");
        
        Author author2 = new Author();
        author2.setName("Alexandra");

        Set<Book> books = new HashSet<Book>();
        
        Book book1 = new Book();
        Book book2 = new Book();
        
        book1.setTitle("The Sun Also Rises");
        book2.setTitle("The old man and the sea");
       // book1.setAuthor(author1);
        
        books.add(book1);
        books.add(book2);
        
        author1.setBooks(books);
        
        
	authorDAO.saveAuthor(author1);
		
	System.out.println("Author :"+author1);
		
        context.close();
    
       //Code without Spring 
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        
//        //create a Book entity
//        
//        Author author1 = new Author();
//        author1.setName("Hernest Hemingway");
//        author1.setEmail("HernestHemingway@hotmail.com");
//        
//        Author author2 = new Author();
//        author2.setName("Alexandra");
//        
//        
//        Set<Book> books = new HashSet<Book>();
//        
//        Book book1 = new Book();
//        Book book2 = new Book();
//        
//        book1.setTitle("The Sun Also Rises");
//        book2.setTitle("The old man and the sea");
//       // book1.setAuthor(author1);
//        
//        books.add(book1);
//        books.add(book2);
//        
//        author1.setBooks(books);
//        
//        //persists the book entity
//        session.save(author1);
//        session.save(author2);
//              
//        session.getTransaction().commit();
//        session.close();
//        
//        sessionFactory.close();
 
        
    }
    
}
