package com.supinfo.suptravel.rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

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
@Path("/find")
public class FindTrip {
	@Path("{camp}")
	@GET
	@Produces("application/json")
	public Response tripByCampus(@PathParam("camp") String camp, @Context ServletContext context, @Context HttpServletRequest req) throws JSONException {
		JSONObject global = new JSONObject();
		TripDAO tdao = new TripDAO();
		HttpSession session = req.getSession();
		List<String> l = tdao.listTripsbyCampus(camp);
		global.put(camp, l);
		UriBuilder builder = UriBuilder.fromPath(context.getContextPath());
		session.setAttribute("tripincampus",global);
		session.setAttribute("campsearch",camp);
        builder.path("/connected/tripbycampus.jsp");
		return Response.seeOther(builder.build()).build();
	}
} 