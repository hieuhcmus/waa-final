package cs545.airline.configuration;

import cs545.airline.rs.AirlineRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestConfig extends Application {
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public RestConfig() {
		classes.add(AirlineRestService.class);
		classes.add(JacksonConfig.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
