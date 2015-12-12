package com.supinfo.suptravel.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.supinfo.suptravel.dao.TripDAO;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/campus")
public class TripByCampus {
	@GET
	@Produces("application/json")
	public Response tripByCampus() throws JSONException {
		JSONObject global = new JSONObject();
		JSONObject trip = new JSONObject();
		JSONObject campus = new JSONObject();
		TripDAO tdao = new TripDAO();
		List<Object[]> l = tdao.restlistTripsbyCampus();
		
		String cname_cur;
		String cname_old = null;
		String tname;
		for (Object[] st : l) {
			tname = (String) st[0];
			cname_cur = (String) st[1];
			if (cname_cur.equals(cname_old)) {
				trip.put("trip", tname);
			} else {
				trip.put("trip", tname);
				campus.put(cname_cur, trip);
				trip = new JSONObject();
				cname_old = cname_cur;
			}
			
		}
		global.put("campus", campus);
		
		String result = "Trip List in JSON organised by campus: \n\n" + global;
		return Response.status(200).entity(result).build();
	}
} 