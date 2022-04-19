package Clase11.service;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

@Path(/users)
public class ServiceUser {
	
	@GET
	@Path("/consultar")
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsers consultarTodo(VOUsers users) { }
	
	@GET
	@Path("/consultar/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsers consultarUser(@PathParam("id") int idusers, VOUsers users) { }	
	
	@POST
	@Path("/insertar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsers cargarDatos(@FormParam("id, nombre, apellido") int idusers, String nom, String ape, VOUsers users) {	}
	
	@PUT
	@Path("/editar/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsers editarDatos(@PathParam("id") int idusers, VOUsers users) { }
	
	@DELETE
	@Path("/eliminar/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsers eliminarUser(@PathParam("id") int idusers, VOUsers users) { }
}