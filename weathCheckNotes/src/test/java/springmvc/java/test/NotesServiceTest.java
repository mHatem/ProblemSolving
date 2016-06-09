package springmvc.java.test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import springmvc.java.config.WebConfig;
import springmvc.java.domain.Notes;
import springmvc.java.domain.User;
import springmvc.java.service.NotesService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={WebConfig.class}, loader=AnnotationConfigWebContextLoader.class)
public class NotesServiceTest {
	
	@Autowired
	private NotesService notesService;
	
	@Test
	public void testUserService() throws ParseException {

		Notes note = new Notes();
		note.setNote("Test Note");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Date todayWithZeroTime = formatter.parse(formatter.format(today));
		note.setDate(todayWithZeroTime);
		note.setUserId(1L);
		note.setType(0);
		
		notesService.saveNote(note);
		
		note = notesService.getNotesByDate(todayWithZeroTime);
		assertTrue(note != null);
		
	
	}

}
