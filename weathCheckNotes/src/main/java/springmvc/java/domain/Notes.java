package springmvc.java.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notes")
public class Notes {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID" , unique=true , nullable = false)
	private Long id;
	@Column(name="DATE" , nullable = true)
    private Date date;
	@Column(name="NOTE" , nullable = false)
    private String note;
	@Column(name="TYPE" , nullable = false)
    private Integer type;
	@Column(name="USERID" , nullable = false)
    private Long userId;
	@Column(name="RANGEFROM")
    private Integer rangeFrom;
	@Column(name="RANGETO")
    private Integer rangeTo;
	
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRangeFrom() {
		return rangeFrom;
	}
	public void setRangeFrom(Integer rangeFrom) {
		this.rangeFrom = rangeFrom;
	}
	public Integer getRangeTo() {
		return rangeTo;
	}
	public void setRangeTo(Integer rangeTo) {
		this.rangeTo = rangeTo;
	}
    
    
    
}
