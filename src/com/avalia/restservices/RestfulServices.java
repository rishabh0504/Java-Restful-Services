package com.avalia.restservices;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avalia.database.DataBase;

@Path("/path")
public class RestfulServices {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<String> getResponce() {
		DataBase db = new DataBase();
		List<String> list = db.get();
		return list;
	}

	@PUT
	@Path("put")
	@Produces(MediaType.TEXT_PLAIN)
	public List<String> putResponce(String data) {
		DataBase db = new DataBase();
		List<String> list = db.put(data);
		return list;
	}

	@POST
	@Path("post")
	@Produces(MediaType.TEXT_PLAIN)
	public List<String> postResponce(String oldData, String newData) {
		DataBase db = new DataBase();
		List<String> list = db.post(oldData, newData);
		return list;
	}

	@DELETE
	@Path("delete/data")
	@Produces(MediaType.TEXT_PLAIN)
	public List<String> deleteResponce(String data) {
		DataBase db = new DataBase();
		List<String> list = db.delete(data);
		return list;

	}
}
