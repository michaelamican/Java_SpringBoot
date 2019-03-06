package com.CodingDojo.DojoOverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, message="Please enter a first name")
	private String fname;
	@Size(min=1, message="Please enter a last name")
	private String lname;
	@Size(min=1, message="Please enter a city")
	private String city;
	@Size(max=2, message="Please enter a state")
	private String state;
	@Size(min=1, message="Please enter a username")
	private String username;
	@Email(message="Email must be valid")
	private String email;
	@Size(min=5, message="Password must be greater than 5 characters")
	private String password;
	@Transient
	private String pWConf;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(targetEntity=User.class, mappedBy="events", fetch = FetchType.EAGER)
	private List<Event> event;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<UserEvent> headcount;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="comments",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Comment> comments;
	private List<User> users;
	
	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getpWConf() {
		return pWConf;
	}

	public void setpWConf(String pWConf) {
		this.pWConf = pWConf;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	public List<UserEvent> getHeadcount() {
		return headcount;
	}

	public void setHeadcount(List<UserEvent> headcount) {
		this.headcount = headcount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
