package com.example.simpan.pinjam.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class DataTransaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public enum ActivityTransactionStatus {
		MENYERAHKAN,
		MEMINJAMKAN,
		MENGEMBALIKAN,
		MENGAMBIL
	}
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "member_id")
	private String memberId;
	
	//@Enumerated(EnumType.STRING)
	@Column(name = "activity_transaction")
	private String activityTransaction;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "date_transaction")
	private Date dateTransaction;
	

	@Column(name = "created_timestamp")
	private Timestamp createdTimestamp;
	
	
	@Column(name = "updated_timestamp")
	private Timestamp updatedTimestamp;

}
