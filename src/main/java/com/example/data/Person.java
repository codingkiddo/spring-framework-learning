package com.example.data;

import java.util.Date;

import lombok.Data;

@Data
public class Person {
	private Integer id;
	  private String firstName;
	  private String lastName;
	  private Date dateOfBirth;
	  private String placeOfBirth;

}
