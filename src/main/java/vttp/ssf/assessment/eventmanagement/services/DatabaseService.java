package vttp.ssf.assessment.eventmanagement.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonObject;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Service
public class DatabaseService {

	@Autowired
	RedisRepository redRepo;
    
    // TODO: Task 1


    public List<Event> readFile(String fileName) throws FileNotFoundException {


        String pathFileName = "/Users/Kimberly 1/Desktop/vttp2023-batch4-ssf-assessment/events.json";

		File eventsFile = new File(pathFileName);
		FileInputStream is = new FileInputStream(eventsFile);

		List<Event> events = new ArrayList<>();
		JsonReader jsonReader = Json.createReader(is);
		JsonArray jsonArray = jsonReader.readArray();
		for (JsonValue jsonValue : jsonArray) {
			Event event = new Event();
			
			JsonObject jsonObject = jsonValue.asJsonObject();

			event.setEventId(Integer.valueOf(jsonObject.get("eventId").toString()));
			event.setEventName(jsonObject.get("eventName").toString());
            event.setEventSize(Integer.valueOf(jsonObject.get("eventSize").toString()));
            event.setEventDate(Long.valueOf(jsonObject.get("eventDate").toString()));
            event.setParticipants(Integer.valueOf(jsonObject.get("participants").toString()));
			events.add(event);
		}
		
        return events;

    }


   
}
