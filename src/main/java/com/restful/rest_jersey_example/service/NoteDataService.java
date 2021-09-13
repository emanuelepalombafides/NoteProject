package com.restful.rest_jersey_example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.restful.rest_jersey_example.DatabaseNote;
import com.restful.rest_jersey_example.model.Note;

public class NoteDataService {
	
	private DatabaseNote repo = new DatabaseNote();

	public String getIt() {
		return "Ciao Emanuele!";
	}
	
	public List<Note> getAllNotes(){
		
		return repo.getAllNotes();
	}
	
	
	
	
}
