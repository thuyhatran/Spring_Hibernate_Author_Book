/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author Administrator
 */   
@Entity
@Table(name="AUTHOR")

public class Author implements Serializable{
        @Id
//       @GeneratedValue
                      
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="author_seq")
	@SequenceGenerator(
		name="author_seq",
		sequenceName="author_sequence",
		allocationSize=1
	)
        
        
        @Column(name="AUTHOR_ID")
        private long id;
        
        private String name;
        private String email;
        
        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        
        private Set<Book> books;

        public Author() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<Book> getBooks() {
            return books;
        }

        public void setBooks(Set<Book> books) {
            this.books = books;
        }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", name=" + name + ", email=" + email + ", books=" + books + '}';
    }
        
        
        
        
        
    
    
}
