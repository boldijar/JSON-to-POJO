package com.boldijarpaul.jsontopojo.servlets;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.boldijarpaul.jsontopojo.entities.ClassFile;
import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.helper.JsonHelper;
import com.boldijarpaul.jsontopojo.parser.ClassObjectConverter;
import com.boldijarpaul.jsontopojo.parser.ParseJson;

@Path("/json")
public class JsonServlet {

	@POST
	@Path("/{root}")
	public Response getClasses(String json, @PathParam("root") String root,
			@QueryParam("package") String packageName) {
		if (packageName != null && packageName.trim().length() == 0) {
			packageName = null;
			/* if we only have white spaces remove them */
		}
		if (!JsonHelper.jsonValid(json)) {
			/* invalid json */
			return Response
					.status(Status.BAD_REQUEST)
					.entity("JSON error")
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers",
							"origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods",
							"GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.header("Access-Control-Max-Age", "1209600").build();
		}
		ClassObject classObject = ParseJson.parse(json, root, packageName);
		ClassFile[] classes = ClassObjectConverter
				.classObjectToClassFileArray(classObject);
		return Response
				.ok(classes)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();

	}
}
