package com.boldijarpaul.jsontopojo.servlets;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
public class JsonServlet {
	
	@POST
	@Path("/json")
	public String getImage() {
		return "Give me a star! https://github.com/BoldijarPaul/JSON-to-POJO";
	}
}
