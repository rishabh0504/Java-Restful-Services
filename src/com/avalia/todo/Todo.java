package com.avalia.todo;

import java.net.UnknownHostException;

import com.avalia.todo.db.DBManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class Todo {
	private String title;
	private String desc;
	private boolean completed;

	public Todo(DBObject obj) {
		BasicDBObject object = new BasicDBObject();
		object = (BasicDBObject) obj;
		this.title = object.getString("title");
		this.desc = object.getString("desc");
		this.completed = object.getBoolean("completed");
	}

	public Todo(String title, String desc, boolean completed) {
		this.title = title;
		this.desc = desc;
		this.completed = completed;
	}

	public Todo(String newTodo) throws UnknownHostException {
		JsonElement obj = new JsonParser().parse(newTodo);
		if (obj instanceof JsonObject) {
			JsonObject todo = (JsonObject) obj;
			this.title = todo.get("title").getAsString();
			this.desc = todo.get("desc").getAsString();
			this.completed = todo.get("completed").getAsBoolean();
		}
	}

	public Todo() {
	}

	public void save() throws UnknownHostException {
		DBCollection collection = DBManager.getDB().getCollection("todos");
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("title", title);
		dbObject.put("desc", desc);
		dbObject.put("completed", completed);
		collection.insert(dbObject);
	}

	@Override
	public String toString() {
		return "Title : " + title + " Desc : " + desc + " Completed : "
				+ completed;
	}

	public String delete(String data) throws UnknownHostException {
		DBCollection collection = DBManager.getDB().getCollection("todos");
		BasicDBObject object = new BasicDBObject();
		object.put("desc", JSON.parse(data));
		collection.remove(object);
		return "removed";
	}

	public String update(String updateData) throws UnknownHostException {
		String oldDescription = "";
		String newDescription = "";
		JsonElement obj = new JsonParser().parse(updateData);
		if (obj instanceof JsonObject) {
			JsonObject todo = (JsonObject) obj;
			oldDescription = todo.get("desc").getAsString();
			newDescription = todo.get("newDesc").getAsString();
		}
		DBCollection collection = DBManager.getDB().getCollection("todos");
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("desc", newDescription);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("desc", oldDescription);
		collection.update(searchQuery, newDocument);
		return "updated";

	}

}
