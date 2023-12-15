package vttp.ssf.assessment.eventmanagement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner {

	@Autowired
	private DatabaseService dbSvc;

	@Autowired
	private RedisRepository redRepo;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String pathFileName = "/Users/Kimberly 1/Desktop/vttp2023-batch4-ssf-assessment/events.json";
		List<Event> events = dbSvc.readFile(pathFileName);

		System.out.println("List of events:" + events);

		for(Event event : events){
			redRepo.saveRecord(event);
		}

		System.out.print("Number of events in list:" + redRepo.getNumberOfEvents("events"));

		System.out.print("Event at index 1:" + redRepo.getEvent("events", 1));
		
			


		

		

	}
}