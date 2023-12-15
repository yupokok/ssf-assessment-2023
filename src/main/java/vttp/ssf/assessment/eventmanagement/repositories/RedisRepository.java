package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired @Qualifier("eventsredis")
	RedisTemplate<String, String> template;

	private List<Event> events;

	// TODO: Task 2

	public void saveRecord(Event event){
		String hashKey = "events";
		HashOperations<String, String, String> opsHash = template.opsForHash();
		opsHash.put(hashKey, event.getEventId().toString(),event.toString());
	 }

		
	// TODO: Task 3

	public String getNumberOfEvents(String hashKey){
		HashOperations<String, String, Event> opsHash = template.opsForHash();
    	return Long.toString(opsHash.size(hashKey));

	}


	// TODO: Task 4 NOT DONE YETTTTT I THINK .

	public String getEvent(String key, Integer eventId){
	HashOperations<String, String, String> opsHash = template.opsForHash();
	 return opsHash.get("events", String.valueOf(eventId));

	}


	public List<Event> getAllEvents() {	
        return events;
    }
	
}