package com.boldijarpaul.jsontopojo.servlets;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.helper.JsonHelper;
import com.boldijarpaul.jsontopojo.parser.ClassObjectConverter;
import com.boldijarpaul.jsontopojo.parser.ParseJson;

@Path("/")
public class JsonServlet {

	@POST
	@Path("/json/{root}")
	public Response getClasses(String json, @PathParam("root") String root) {
		if (!JsonHelper.jsonValid(json)) {
			/* invalid json */
			return Response.status(Status.BAD_REQUEST).entity("JSON error")
					.build();
		}
		ClassObject classObject = ParseJson.parse(json, root);
		List<ClassObject> classObjects = ClassObjectConverter
				.getAllClassObjects(classObject);
		String[] classes = new String[classObjects.size()];
		//for(int i=)

	}
}
