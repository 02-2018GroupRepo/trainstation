package bootcamp.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;

import bootcamp.dao.Greeting;
import bootcamp.dao.ReserveTrainJson;
import bootcamp.dao.TrainDatabase;
import bootcamp.dao.TrainStation;
import java.util.ArrayList;

@RestController
public class TrainStationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/{location}", method=RequestMethod.GET)
    public String availableDestinations(@PathVariable String location) {
        return TrainStation.possibleDestinations(location);
    }
    
    @RequestMapping(value="/{location}", method=RequestMethod.POST)
    public String reserveSeat(@PathVariable String location, HttpServletRequest req, HttpServletResponse res) {
    
    	
        try (BufferedReader is = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
        	ArrayList<TrainStation> trainStationList = TrainDatabase.trainDatabase.get(location);
        	
        	Gson gson = new Gson();
        	ReserveTrainJson jsonData = gson.fromJson(is.readLine(), ReserveTrainJson.class);
        	
        	for (TrainStation station : trainStationList) {
        		if (station.getLocation().equalsIgnoreCase(jsonData.getDestination())) {
        			if (station.validateSeatCount(jsonData.getSeatCount())) {
        				return "Confirmed";
        			} else {
        				return "Train is at capacity";
        			}
        		}
        	}
        	return "Destination not available.";
        	
        	
        } catch (Exception e) {
        	System.out.println(e);
        }
        return "error";
    }
}
