package com.example.data;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonDAO implements InitializingBean, DisposableBean {

	private static int count = 0;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> getPersons() {
		
		return namedParameterJdbcTemplate.query("SELECT * FROM person", (ResultSet rs, int rowNum) -> {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setFirstName(rs.getString("first_name"));
			p.setLastName(rs.getString("last_name"));
			p.setDateOfBirth(rs.getDate("date_of_birth"));
			p.setPlaceOfBirth(rs.getString("place_of_birth"));
			return p;
		});
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		PersonDAO.count++;
		System.out.println( " *********** PersonDAO.count ********** : " + PersonDAO.count);
		if (jdbcTemplate != null) {
			System.out.println("****************PersonDAO**************** : afterPropertiesSet()" + jdbcTemplate.getClass());
		} else {
			System.out.println("****************PersonDAO**************** : afterPropertiesSet()" + namedParameterJdbcTemplate.getClass());
		}
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("****************PersonDAO**************** : destroy()" );
	}
}
