package userservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "first_name", nullable = false)
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	@NotEmpty(message = "Please provide your last name")
	private String lastName;
  
  	@CreatedDate
  	@Column(name = "created_time")
  	private Date createdTime;

  	@LastModifiedDate
  	@Column(name = "modified_time")
  	private Date modifiedTime;

// Based on need we can add created by and modified by but for now, we can assume only user can create or modify himself...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

  	public Date getCreatedTime() {
    		return createdTime;
  	}

	  public void setCreatedTime(Date createdTime) {
	    this.createdTime = createdTime;
	  }

	  public Date getModifiedTime() {
	    return modifiedTime;
	  }

	  public void setModifiedTime(Date modifiedTime) {
	    this.modifiedTime = modifiedTime;
	  }
  
}
