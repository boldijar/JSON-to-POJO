package com.boldijarpaul.jsontopojo.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeServlet {

	@GET
	@Path("")
	public Response getText() {
		String response = "Give me a star! https://github.com/BoldijarPaul/JSON-to-POJO"
				+ "\n" + "Do a post at /json/{root name} with your JSON :) \n Last updated: 28/8/2015";
		return Response
				.ok(response)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}
}
