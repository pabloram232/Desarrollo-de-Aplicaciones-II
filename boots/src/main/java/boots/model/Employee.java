package boots.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="employees")
public class Employee implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length=45)
	private String name;
	@Column (length=45)
	private String role;
	@Column (length=45)
	private int age;
	@Temporal(TemporalType.DATE)
	@Column (name="date_created")
	private Date dateCreated;
	private boolean attended;
	
	public Employee(String name, int age,String role,  Date dateCreated, boolean attended) {
		super();
		this.name = name;
		this.role=role;
		this.age = age;
		this.dateCreated = dateCreated;
		this.attended = attended;
	}

	public Employee() {
		this("",0,"",new Date(),false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAgen(int age) {
		this.age = age;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreaated) {
		this.dateCreated = dateCreaated;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", age=" + age + ", dateCreated="
				+ dateCreated + ", attended=" + attended + "]";
	}

	

}
