package com.example.bookInventory.entity;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "publisher")
public class Publisher {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PublisherID")
    private Integer publisherId;
 
    @Column(name = "Name", length = 50, nullable = false)
    private String name;
 
    @Column(name = "City", length = 30)
    private String city;
 
    @Column(name = "StateCode", length = 2)
    private String stateCode;
 
    public Publisher() {}
 
    public Publisher(Integer publisherId, String name, String city, String stateCode) {
        this.publisherId = publisherId;
        this.name = name;
        this.city = city;
        this.stateCode = stateCode;
    }
 
    public Integer getPublisherId() {
        return publisherId;
    }
 
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name=name; }
 
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
 
    @Override
    public String toString() {
        return "Publisher [publisherId=" + publisherId + ", name=" + name +
               ", city=" + city + ", stateCode=" + stateCode + "]";
    }
 
 
	public void setCity(String city) {
		this.city = city;
	}
 
	public String getCity() {
		return city;
	}
 
	public String getStateCode() {
		return stateCode;
	}
}