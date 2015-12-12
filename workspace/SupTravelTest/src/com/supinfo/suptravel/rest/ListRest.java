package com.supinfo.suptravel.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.supinfo.suptravel.bean.Trip;
import com.supinfo.suptravel.dao.TripDAO;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/list")
public class ListRest {

	@GET
	@Produces("application/json")
	public Response getTrips() throws JSONException {
		JSONObject global = new JSONObject();
		JSONObject trip = new JSONObject();
		TripDAO tdao = new TripDAO();
		List<Trip> l = tdao.restlistTrips();
		String tname;
		String tcamp;
		for (Trip t : l) {
			tname = t.getTripname();
			tcamp = t.getCampus();
			trip.put("campus", tcamp);
			global.put(tname, trip);
		}
		
		String result = "Trip List in JSON : \n\n" + global;
		return Response.status(200).entity(result).build();
	}
} 