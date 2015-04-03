package com.avalia.database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DataBase {
	private static DBCollection collection;
	private static BasicDBObject dbObject;

	public static void main(String[] args) throws UnknownHostException {

		DB db = (new MongoClient("localhost", 27017)).getDB("tododatabase");
		collection = db.getCollection("todos");
		dbObject = new BasicDBObject();
		dbObject.put("Name : ", "Rishabh");
		dbObject.put("Name : ", "Rahul ");
		dbObject.put("Name : ", "Ruchi");
		dbObject.put("Name : ", "Vivek");
		collection.insert(dbObject);

	}

	public List<String> get() {
		List<String> list = new ArrayList<String>();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			list.add(cursor.next().toString());
		}
		return list;
	}

	public List<String> put(String data) {
		List<String> list = new ArrayList<String>();
		dbObject.put("Name : ", data);
		collection.insert(dbObject);
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			list.add(cursor.next().toString());
		}

		return list;

	}

	public List<String> post(String oldData, String newData) {
		List<String> list = new ArrayList<String>();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			list.add(cursor.next().toString());
		}
		return null;

	}

	public List<String> delete(String data) {
		return null;

	}

}
