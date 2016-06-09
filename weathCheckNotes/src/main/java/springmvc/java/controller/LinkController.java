package springmvc.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc.java.domain.Notes;
import springmvc.java.domain.User;
import springmvc.java.service.NotesService;

@Controller
@ComponentScan
public class LinkController {

	@Autowired
	private NotesService  notesService;
	
	/**
	 * redirect to register view
	 * @return register view
	 */
	@RequestMapping("/register")
	 public ModelAndView handleRequestRegister(){
	        return new ModelAndView("Register");
	    }
	
	/**
	 * redirect to Adminpanel view after set user notes which get from DB 
	 * @param hsr HttpServletRequest
	 * @return adminpanel view
	 */
	@RequestMapping("/AdminPanel")
	 public ModelAndView handleRequestAdminPanel(HttpServletRequest hsr){
			User loginUuser = (User) hsr.getSession().getAttribute("loginUser");
			List<Notes> notes = notesService.getNotesbyUserId(loginUuser.getId());
	        return new ModelAndView("AdminPanel","userNotes",notes);
	    }
	
	/**
	 * @return Weather View
	 * 
	 */
	@RequestMapping("/Weather")
	 public ModelAndView handleRequestWeather(){
	        return new ModelAndView("Weather");
	    }
}
