package com.avalia.todo.db;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBManager {

	private static DB db;
	private String url = "localhost";
	private int port = 27017;
	private String dbName = "avalia";

	public DBManager() throws UnknownHostException {
		db = (new MongoClient(url, port)).getDB(dbName);

	}

	public static DB getDB() throws UnknownHostException {
		if (db == null) {
			new DBManager();
		}
		return db;
	}

}
