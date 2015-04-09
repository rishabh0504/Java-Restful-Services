package com.avalia.todo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import com.avalia.todo.db.DBManager;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class Todos {
	private DBCollection collection;

	private Todos() {
		try {
			collection = DBManager.getDB().getCollection("todos");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static Todos todos = new Todos();

	public List<Todo> get() {
		List<Todo> list = new ArrayList<Todo>();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			list.add(new Todo(cursor.next()));
		}
		return list;

	}

}
