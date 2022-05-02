package com.example.data;

import java.util.List;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Person> getPersons() {
		
		return jdbcTemplate.query("SELECT * FROM person", (ResultSet rs, int rowNum) -> {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setFirstName(rs.getString("first_name"));
			p.setLastName(rs.getString("last_name"));
			p.setDateOfBirth(rs.getDate("date_of_birth"));
			p.setPlaceOfBirth(rs.getString("place_of_birth"));
			return p;
		});
		
	}
	
}
