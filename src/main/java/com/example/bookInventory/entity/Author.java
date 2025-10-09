package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    private Long authorId;
 
    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;
 
    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;
 
    @Column(name = "PhotoUrl", length = 255)
    private String photoUrl;
    
    

    public Author() {
		super();
	}
 
	public Author(Long authorId, String firstName, String lastName, String photoUrl) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photoUrl = photoUrl;
	}
 
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", "
				+ "photoUrl="
				+ photoUrl + "]";
	}
 
	public Long getAuthorId() {
		return authorId;
	}
 
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getPhotoUrl() {
		return photoUrl;
	}
 
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
