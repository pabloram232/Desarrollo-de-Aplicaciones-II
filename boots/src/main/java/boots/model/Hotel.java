package boots.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="hotels")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length=45)
	private String name;
	@Column (length=45)
	private String address;
	@Column (length=20)
	private String telephone;
	
	
	public Hotel(String name, String address, String telephone) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	public Hotel() {
		this("","","");
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone + "]";
	}
	
	
	
	
}
