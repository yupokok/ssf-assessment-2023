package vttp.ssf.assessment.eventmanagement.controllers;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.json.JsonReader;
import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.UserReg;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping(path="events")
public class EventController {

	@Autowired
	RedisRepository redRepo;

	@Autowired
	DatabaseService dbSvc;

	//TODO: Task 5

	@GetMapping(path = "/list")
	public String displayEvents(Model model)throws FileNotFoundException {
		String pathFileName = "/Users/Kimberly 1/Desktop/vttp2023-batch4-ssf-assessment/events.json";
		List<Event> events = dbSvc.readFile(pathFileName);
		model.addAttribute("events", events);
		// List<Event> events = 
		// JSONParser parser = new JSONParser();  
		// JSONObject json = (JSONObject) parser.parse(stringToParse); redRepo.getAllEvents()
		

		// List<Event> events;
		// JsonParser parser = Json.createParser(new StringReader(redRepo.getAllEvents().toString()));
		// parser.

		return "eventslist";
	} 

	

	

}
