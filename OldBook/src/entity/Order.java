package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="id")
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(generator="id")
	private int id;
	@Column(name="status")
	private String status;
	@Column(name="salername")
	private String salername;
	@Column(name="buyername")
	private String buyername;
	@Column(name="moneystatus")
	private String moneystatus;
	@Temporal(TemporalType.DATE)
	private Date ordertime;
	

	@OneToOne
	@JoinColumn(name="b_id")
	@Cascade(CascadeType.ALL)
	private Book book;
	
	
	
	



	public String getMoneystatus() {
		return moneystatus;
	}



	public void setMoneystatus(String moneystatus) {
		this.moneystatus = moneystatus;
	}



	public Date getOrdertime() {
		return ordertime;
	}



	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}



	public int getId() {
		return id;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	public String getSalername() {
		return salername;
	}


	public void setSalername(String salername) {
		this.salername = salername;
	}


	public String getBuyername() {
		return buyername;
	}


	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	

}
