package cs545.airline.rs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value = "airplanes", description = "REST API to interact with Airplane service")
@Path("airplanes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AirplaneRestService {
	@Inject
	private AirplaneService airplaneService;

	@GET
	@ApiOperation(value = "Get all Airplanes", notes = "Get all the Airplanes",
			responseContainer = "List", response = Airplane.class)
	public List<Airplane> getAllAirplanes() {
		return airplaneService.findAll();
	}

	@ApiOperation(value = "Get Airplane by id", notes = "Get Airplane by id", response = Airplane.class)
	@Path("/{id}")
	@GET
	public Airplane getAirplane(@PathParam("id") long id) {
		return airplaneService.findById(id);
	}

	@ApiOperation(value = "Delete an Airplane by given id", notes = "Delete an Airplane by given id", response = Airplane.class)
	@Path("/{id}")
	@DELETE
	public void deleteAirplane(@PathParam("id") long id) {
		airplaneService.delete(id);
	}
}
