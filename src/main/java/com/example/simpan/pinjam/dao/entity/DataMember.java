package com.example.simpan.pinjam.dao.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "anggota")
public class DataMember {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_birth")
	private String dateBirth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "team_id")
	private String teamId;
	
	@Column(name = "created_timestamp")
	private Timestamp createdTimestamp;
	
	
	@Column(name = "updated_timestamp")
	private Timestamp updatedTimestamp;

}
