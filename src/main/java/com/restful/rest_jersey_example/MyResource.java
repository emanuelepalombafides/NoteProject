
package com.restful.rest_jersey_example;

import java.util.List;
import java.util.Map;

import com.restful.rest_jersey_example.model.Note;
import com.restful.rest_jersey_example.service.NoteDataService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/note")
public class MyResource {
	
	NoteDataService noteDataService = new NoteDataService();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Ciao Emanuele!";
    }
    
    @GET
	@Path("/allNotes")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getNotes() {
		List<Note> notes= noteDataService.getAllNotes();
		GenericEntity<List<Note>> entity = new GenericEntity<List<Note>>(notes) {};
		return Response.ok(entity).build();	
	}
    
	@GET
	@Path("/getNoteById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getNoteById(@PathParam("id") int id) {
		return "Nota con id: "+id;
	}
	
//	@GET
//	@Path("/{title}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getNoteByTitle(@PathParam("title") String title) {
//		return title;
//	}
//	
//	@GET
//	@Path("/{author}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String findByAuthor(@PathParam("author") String author) {
//		return author;
//	}
	
//	@POST
//	@Path("/add-note")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Note createNote(Note newNote) {
//		
//		//logica salvataggio db;
//		return newNote;
//	}
}
