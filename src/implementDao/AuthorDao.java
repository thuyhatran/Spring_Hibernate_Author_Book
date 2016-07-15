/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementDao;

import bean.Author;
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate4.HibernateTemplate;


/**
 *
 * @author thuyha
 */
public class AuthorDao {
    
    
    HibernateTemplate template;  
    public void setTemplate(HibernateTemplate template) {  
        this.template = template;  
    }  
    //method to save   
    public void saveAuthor(Author e){  
        template.save(e);
    }  
    //method to update   
    public void updateAuthor(Author e){  
        template.update(e);  
    }  
    
    //method to delete employee  
    public void deleteAuthor(Author e){  
        template.delete(e);  
    }  
    //method to return one employee of given id  
    public Author getById(int id){  
        Author e=(Author)template.get(Author.class,id);  
        return e;  
    }  
    //method to return all employees  
    public List<Author> getAuthors(){  
        List<Author> list=new ArrayList<Author>();  
        list=template.loadAll(Author.class);  
        return list;  
    }  


    
}
