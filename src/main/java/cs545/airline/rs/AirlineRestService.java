package cs545.airline.rs;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("airlines")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AirlineRestService {
	@Inject
	private AirlineService airlineService;

	@GET
	public List<Airline> getAllAirlines() {
		return airlineService.findAll();
	}

	@Path("/{id}")
	@GET
	public Airline getAirline(@PathParam("id") long id) {
		return airlineService.findById(id);
	}
}
