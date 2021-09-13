package com.restful.rest_jersey_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.RSAException;
import com.restful.rest_jersey_example.model.Note;

public class DatabaseNote {
	Connection conn;
	Statement stmt;
	
	public DatabaseNote() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/note?serverTimezone=UTC","root","Emanuele2001!");
		} catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	
	public List<Note> getAllNotes(){
		List<Note> note = new ArrayList<Note>();	
			try{
				String sql = new String("SELECT id,title,author FROM GoogleKeeps");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					Note es = new Note();
					es.setId(rs.getInt("id"));
					es.setTitle(rs.getString("title"));
					es.setAuthor(rs.getString("author"));
					
					note.add(es);
					
				}
					conn.close();
					System.out.println("Database Query Successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return note;
		}
	
}

