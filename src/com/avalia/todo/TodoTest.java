package com.avalia.todo;

import java.net.UnknownHostException;
import java.util.List;

public class TodoTest {
	public static void main(String[] args) {
		try {
			Todo todo = new Todo("todo1", "this is my first todo.", false);
			todo.save();
			List<Todo> list = Todos.todos.get();
			for (Todo t : list) {
				System.out.println(t);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
