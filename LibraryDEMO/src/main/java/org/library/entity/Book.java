package org.library.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="books")
public class Book implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="description", nullable=true)
    private String description;
    
    @ManyToMany(targetEntity=Author.class, fetch=FetchType.EAGER)
    @JoinTable(	name="books_authors", 
    		joinColumns={@JoinColumn(name="id_book")},
	    	inverseJoinColumns={@JoinColumn(name="id_author")})
    private List<Author> authors;
    
    @Column(name="amount_of_page", nullable=false)
    private int amountOfPage;
    
    @ManyToOne(targetEntity=Book.class, fetch=FetchType.LAZY)
    private Publication publication;
    
    @Column(name="year_of_publishing", nullable=false)
    private int year;
    
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

    public int getAmountOfPage() {
        return amountOfPage;
    }

    public void setAmountOfPage(int amountOfPage) {
        this.amountOfPage = amountOfPage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
	return "Book [id=" + id + ", name=" + name + ", description="
		+ description + ", authors=" + authors + ", amountOfPage="
		+ amountOfPage + ", publication=" + publication + ", year="
		+ year + "]";
    }
    

}