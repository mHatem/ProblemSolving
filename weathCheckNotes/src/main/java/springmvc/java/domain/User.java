package springmvc.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID" , unique=true , nullable = false)
	private Long id;
	@Column(name="NAME" , nullable = false)
    private String name;
	@Column(name="EMAIL" , nullable = false, unique = true)
    private String email;
	@Column(name="PASSWORD" , nullable = false)
    private String password;
	@Column(name="MOBILE" , nullable = false)
    private String mobileNumber;
	@Column(name="TYPE" , nullable = false)
    private Integer type;
	
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
    
    
}
