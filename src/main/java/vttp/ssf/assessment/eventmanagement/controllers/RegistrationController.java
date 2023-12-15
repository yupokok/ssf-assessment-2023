package vttp.ssf.assessment.eventmanagement.controllers;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.JsonReader;
import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.UserReg;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping(path = "/events")
public class RegistrationController {
    
    @Autowired
    RedisRepository redRepo;

    @Autowired 
    DatabaseService dbSvc;


    // TODO: Task 6 SORRY IDK how to Parse Json Object as Java Object!!!

    @GetMapping(path = "/register/{eventId}")
    public String register(@PathVariable("eventId") Integer eventId, Model model) {


        UserReg reg = new UserReg(); 
        model.addAttribute("userReg", reg);

		return "registration";
	}


    // TODO: Task 7

    @PostMapping("/processing")
    public ModelAndView processRegistration(@Valid @ModelAttribute("userReg") UserReg userReg, BindingResult result,
    Model model, @RequestParam String birthday, @RequestBody String body) {

        if (result.hasErrors()) {

            ModelAndView mav = new ModelAndView("registration");
            return mav;
        }
        
        ModelAndView mav = new ModelAndView("SuccessRegistration");
            return mav;
        
    // private Integer calculateAge(String birthday){


    //     return age;
        
    // }


}

}