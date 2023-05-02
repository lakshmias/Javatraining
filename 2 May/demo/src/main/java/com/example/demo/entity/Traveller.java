package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "atbl_traveller")
public class Traveller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long travellerId;
	
	@Column(nullable = false,unique = true)
	private String travellerName;
	
	@Column(nullable = false)
	private String travellerPwd;
	
	@Column(nullable = false)
	private String roles;
	
	
}
