package com.boldijarpaul.jsontopojo.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

 

@Path("/")
public class HomeServlet {

	@GET
	@Path("")
	public String getImage() {
		return "Give me a star! https://github.com/BoldijarPaul/JSON-to-POJO"
				+ "\n"
				+ "Do a post at /json/{root name} with your JSON :)";
	}

}
