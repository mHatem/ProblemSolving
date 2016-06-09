package springmvc.java.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.Notes;
import springmvc.java.domain.User;
import springmvc.java.service.NotesService;

@Controller
@ComponentScan
public class NotesController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotesController.class);
	
	@Autowired
	private NotesService notesService;

	/** 
	 *  Create new note setting today date and user id save in data base
	 * @param hsr HttpServletRequest
	 * @param  note string 
	 * @return AdminPanel view
	 */
	@RequestMapping(value = "/saveNote", method = RequestMethod.POST)
	public ModelAndView saveNote(HttpServletRequest hsr, @RequestParam(value = "note") String note) {
		try {
			logger.debug("NotesController : saveNote is called ");
			User loginUser = (User) hsr.getSession().getAttribute("loginUser");
			Notes newNote = new Notes();
			newNote.setNote(note);
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date today = new Date();
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			newNote.setDate(todayWithZeroTime);

			newNote.setType(0);
			newNote.setUserId(loginUser.getId());

			notesService.saveNote(newNote);
			hsr.getSession().setAttribute("note", newNote.getNote());
			hsr.getSession().setAttribute("userNotes", notesService.getNotesbyUserId(loginUser.getId()));
			logger.debug("NotesController : new Note is Saved ");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ModelAndView("AdminPanel", "message", "New note successufly saved");
	}
	/**
	 * adding the four pre defined notes
	 * @param hsr HttpServletRequest
	 * @param note note string from 1 to 10 
	 * @param note2 note string from 10 to 15
	 * @param note3 note string from 15 to 20
	 * @param note4 note string greater thatn 20
	 * @return
	 */
	@RequestMapping(value = "/savePreNote", method = RequestMethod.POST)
	public ModelAndView savePreNote(HttpServletRequest hsr, @RequestParam(value = "note") String note,
			@RequestParam(value = "note") String note2, @RequestParam(value = "note") String note3,
			@RequestParam(value = "note") String note4

	) {
		try {
			logger.debug("NotesController : savePreNote is called ");
			User loginUser = (User) hsr.getSession().getAttribute("loginUser");
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date today = new Date();
			Date todayWithZeroTime;

			todayWithZeroTime = formatter.parse(formatter.format(today));

			Notes newNote = new Notes();
			newNote.setNote(note);
			newNote.setRangeFrom(1);
			newNote.setRangeTo(10);
			newNote.setType(1);
			newNote.setUserId(loginUser.getId());
			newNote.setDate(todayWithZeroTime);
			notesService.saveNote(newNote);

			Notes newNote2 = new Notes();
			newNote2.setNote(note2);
			newNote2.setType(1);
			newNote2.setUserId(loginUser.getId());
			newNote2.setRangeFrom(10);
			newNote2.setRangeTo(15);
			newNote2.setDate(todayWithZeroTime);
			notesService.saveNote(newNote2);

			Notes newNote3 = new Notes();
			newNote3.setNote(note3);
			newNote3.setType(1);
			newNote3.setUserId(loginUser.getId());
			newNote3.setRangeFrom(15);
			newNote3.setRangeTo(20);
			newNote3.setDate(todayWithZeroTime);
			notesService.saveNote(newNote3);

			Notes newNote4 = new Notes();
			newNote4.setNote(note3);
			newNote4.setType(1);
			newNote4.setUserId(loginUser.getId());
			newNote4.setRangeFrom(20);
			newNote4.setDate(todayWithZeroTime);
			notesService.saveNote(newNote4);
			hsr.getSession().setAttribute("userNotes", notesService.getNotesbyUserId(loginUser.getId()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("AdminPanel", "message", "Notes successufly saved");
	}

	/**
	 * Delete note using note id and send notes without deleted note
	 * @param hsr HttpServletRequest
	 * @param noteId note id
	 * @return AdminPanel view 
	 */
	@RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
	public ModelAndView deleteNote(HttpServletRequest hsr, @RequestParam(value = "noteId") Long noteId) {
		logger.debug("NotesController : deleteNote is called ");
		notesService.deleteNotebyId(noteId);
		User loginUuser = (User) hsr.getSession().getAttribute("loginUser");
		List<Notes> notes = notesService.getNotesbyUserId(loginUuser.getId());
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userNotes", notes);
		params.put("message", "note with id  "+ noteId + " is Deleted ");
		logger.debug("NotesController : note with id  "+ noteId + " is Deleted ");
		return new ModelAndView("AdminPanel", params);
	}

}
