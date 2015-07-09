package com.bluetag.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestResource {

	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlayers(){
		return "Hi Vijai!!!";
	}
	
}
