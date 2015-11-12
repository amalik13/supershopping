package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ADMINPRODUCT database table.
 * 
 */



@Entity
@Table(name="ADMINPRODUCT", schema="testuserdb")
@NamedQuery(name="Adminproduct.findAll", query="SELECT a FROM Adminproduct a")
public class Adminproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_JUST_FOR_TEST")
    @SequenceGenerator(schema="testuserdb", name="SEQ_JUST_FOR_TEST", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)	
	@Column(name="ROW_ID")
	private String rowId;

	private String totalprice;

	private String username;

	public Adminproduct() {
	}

	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}