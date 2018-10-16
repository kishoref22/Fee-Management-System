package pro.pojo;
import java.sql.Date;

public class Student {
     private String name;
     private String course;
     private String email;
     private String id;
     private String phone_no;
     private Date dob;
     private String address;
     private int fee_paid;
     private int fee_due;
	public Student(String name, String course, String email, String id, String phone_no, Date dob, String address,
			int fee_paid, int fee_due) {
		super();
		this.name = name;
		this.course = course;
		this.email = email;
		this.id = id;
		this.phone_no = phone_no;
		this.dob = dob;
		this.address = address;
		this.fee_paid = fee_paid;
		this.fee_due = fee_due;
	}
	public Student() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFee_paid() {
		return fee_paid;
	}
	public void setFee_paid(int fee_paid) {
		this.fee_paid = fee_paid;
	}
	public int getFee_due() {
		return fee_due;
	}
	public void setFee_due(int fee_due) {
		this.fee_due = fee_due;
	}
     
	
}
