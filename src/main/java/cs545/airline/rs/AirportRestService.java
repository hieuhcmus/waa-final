package cs545.airline.rs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "airports", description = "REST API to interact with Airport service")
@Path("airports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AirportRestService {
	@Inject
	private AirportService airportService;

	@GET
	@ApiOperation(value = "Get all Airports", notes = "Get all Airports",
			responseContainer = "List", response = Airport.class)
	public List<Airport> getAllAirports() {
		return airportService.findAll();
	}

	@ApiOperation(value = "Get Airport by id", notes = "Get Airport by given id", response = Airport.class)
	@Path("/{id}")
	@GET
	public Airport getAirport(@PathParam("id") long id) {
		return airportService.findById(id);
	}

	@ApiOperation(value = "Delete an Airport by given id", notes = "Delete an Airport by given id", response = Airport.class)
	@Path("/{id}")
	@DELETE
	public void deleteAirport(@PathParam("id") long id) {
		airportService.delete(id);
	}
}
