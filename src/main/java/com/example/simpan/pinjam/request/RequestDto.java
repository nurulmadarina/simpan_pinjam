package com.example.simpan.pinjam.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name")
	@Size(min = 2, message = "Name should not be less than 3 character")
	private String name;
	
	@JsonProperty("date_birth")
	private String dateBirth;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("team_id")
	private String teamId;
	
	@JsonProperty("price")
	private long price;
	
	@JsonProperty("size_per_page")
	private int size;
	
	@JsonProperty("date_start")
	private Date dateStart;
	
	@JsonProperty("date_end")
	private Date dateEnd;
	
	@JsonProperty("activity_transaction")
	private String activityTransaction;
	
	@JsonProperty("date_transaction")
	private String dateTransaction;
	
	
	
	
}
