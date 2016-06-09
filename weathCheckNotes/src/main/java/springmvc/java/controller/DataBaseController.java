package springmvc.java.controller;

import java.util.*;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBaseController {

	private static final Logger logger = LoggerFactory.getLogger(DataBaseController.class);
	
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplete;
	
	@RequestMapping("/displayNotes")
	public void displayNotes(){
		jdbcTemplete = new JdbcTemplate(dataSource);
		ArrayList<Map<String,Object>>  notes = (ArrayList<Map<String, Object>>) jdbcTemplete.queryForList("Select * From Notes");
		
		for(Map<String, Object> note : notes){
			logger.debug("MYSEQL NOTE " + note);
		}
		
		
	}
}
