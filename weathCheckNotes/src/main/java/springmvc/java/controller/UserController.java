package springmvc.java.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
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
import springmvc.java.service.UserService;

@Controller
@ComponentScan
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private NotesService notesService;

	/**
	 * Save new user after validate data
	 * 
	 * @param name
	 *            User name
	 * @param email
	 *            User Email
	 * @param password
	 *            User password
	 * @param mobile
	 *            User Mobile Phone
	 * 
	 * @return index view
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, @RequestParam(value = "mobile") String mobile) {
		logger.debug("User Controller : Save new user ");
		User uTmp = userService.getUserbyEmail(email);
		if (uTmp != null)
			return new ModelAndView("index", "message", "this email " + email + "is already in the system ");

		if (mobile.length() != 11)
			return new ModelAndView("Register", "message", "Mobile number must be 11 digits only no more no less");
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setMobileNumber(mobile);
		newUser.setPassword(password);
		newUser.setType(0);

		userService.saveUser(newUser);
		logger.debug("User Controller : New user saved Successfuly");
		return new ModelAndView("index", "message", "Welcome " + name);
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.POST)
	public ModelAndView logOut(HttpServletRequest hsr) {
		hsr.getSession().removeAttribute("loginUser");

		logger.debug("User Controller : Log out");
		return new ModelAndView("index");
	}

	/**
	 * Get the weather conditions if login successes else redirect to index and
	 * failed message
	 * 
	 * @param email
	 *            email of login user
	 * @param password
	 *            his password
	 * @return the redirect view based on login process
	 * @throws ParseException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest hsr, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) throws ParseException {
		try {
			logger.debug("User Controller : Login process ");
			User loginUser = userService.getUserbyEmail(email);
			if (loginUser != null && loginUser.getPassword().equals(password)) {

				logger.debug("User Controller : Login successed and called the restful web service openweathermap ");

				hsr.getSession().setAttribute("loginUser", loginUser);
				JSONObject json = readJsonFromUrl(
						"http://api.openweathermap.org/data/2.5/weather?q=Egypt,Giza&units=metric&appid=a93499cb076d5a6a8868af34a54e383b");
				double temp = (double) json.getJSONObject("main").get("temp");
				double minTemp = (double) json.getJSONObject("main").get("temp_min");
				double maxTemp = (double) json.getJSONObject("main").get("temp_max");

				hsr.getSession().setAttribute("temp", Integer.toString((int) temp));
				hsr.getSession().setAttribute("temp_min", Integer.toString((int) minTemp));
				hsr.getSession().setAttribute("temp_max", Integer.toString((int) maxTemp));

				logger.debug("Get the note of today or get pre defined one");
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date today = new Date();
				Date todayWithZeroTime = formatter.parse(formatter.format(today));
				Notes todayNote = notesService.getNotesByDate(todayWithZeroTime);
				if (todayNote == null) {
					if (temp > 20)
						todayNote = notesService.getNotesByRangFromAndRangeTo(20, null);
					else if (temp > 15)
						todayNote = notesService.getNotesByRangFromAndRangeTo(15, 20);
					else if (temp > 10)
						todayNote = notesService.getNotesByRangFromAndRangeTo(10, 15);
					else if (temp > 1)
						todayNote = notesService.getNotesByRangFromAndRangeTo(1, 10);
					else {
						hsr.getSession().setAttribute("note", "there is no note today");
					}
				}
				if (todayNote != null) {
					hsr.getSession().setAttribute("note", todayNote.getNote());
				}
				logger.debug("User Controller : Get the paramters of temprture and motes and rediect to Weather view ");

			} else {
				logger.debug("User Controller : Login faild and redirect to index");
				return new ModelAndView("index", "message", "Login failed");
			}

		} catch (JSONException e) {
			logger.debug("Webservice of weather check don't work");
			e.printStackTrace();
			return new ModelAndView("index", "message", "error Messege : Webservice of weather check don't work");
		} catch (IOException e) {
			logger.debug("Webservice of weather check don't work");
			e.printStackTrace();
			return new ModelAndView("index", "message", "error Messege : Webservice of weather check don't work");
		}
		return new ModelAndView("Weather");
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * Returns the weather conditions as a json object
	 * 
	 * This method is for getting the weather conditions using udacity api for
	 * weather condition and it is done for Cairo, Egypt place.
	 *
	 * @param url
	 *            of the webservice including the place to get its weather
	 *            conditions
	 * @return a json object of the weather's webservice
	 */
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

		if (url != null && !url.isEmpty()) {
			InputStream is = new URL(url).openStream();
			try {
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				String jsonText = readAll(rd);
				JSONObject json = new JSONObject(jsonText);
				return json;
			} finally {
				is.close();
			}
		}
		return null;
	}
}
