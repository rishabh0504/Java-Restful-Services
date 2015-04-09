package com.avalia.restservices;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;

import com.avalia.todo.Todo;
import com.avalia.todo.Todos;
import com.google.gson.Gson;

@Path("/todos")
public class RestfulServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws JSONException {
		List<Todo> list = Todos.todos.get();
		String json = new Gson().toJson(list);
		return json.toString();
	}

	@PUT
	@Path("put")
	@Produces(MediaType.APPLICATION_JSON)
	public String put(String newTodo) throws JSONException, JsonParseException,
			JsonMappingException, IOException {
		Todo todo = new Todo(newTodo);
		todo.save();
		return "All done";

	}

	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON)
	public String post(String oldData, String newData) {

		return null;
	}

	@DELETE
	@Path("delete/desc")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(String data) throws UnknownHostException {
		Todo todo = new Todo();
		String responce = todo.delete(data);
		return responce;
	}
}
