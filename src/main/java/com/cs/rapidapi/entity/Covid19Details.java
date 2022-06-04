package com.cs.rapidapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "covid19_Details")
public class Covid19Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String city;
	private String province;
	private String country;
	private String lastUpdate;
	private String keyId;
	private float confirmed;
	private float deaths;
	private String recovered;

}
