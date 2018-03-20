package cs545.airline.bean;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class AirlineBean {
    @Inject
    private AirlineService airlineService;
    private Airline airline = new Airline();
    private List<Airline> airlines;

    @PostConstruct
    public void init() {
        airlines = airlineService.findAll();
    }

    public Airline getAirplane() {
        return airline;
    }

    public String createAirline() {
        airlineService.create(airline);
        return "airlineList.xhtml?faces-redirect=true";
    }

    public List<Airline> getAirlines() {
        System.out.println(airlines);
        return airlines;
    }

    public String editAirlineRecord(long id) {
        Airline a = airlineService.findById(id);
        Map<String, Object> sessionMap =
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("editAirline", a);
        return "editAirline.xhtml?faces-redirect=true";
    }

    public String updateAirline(Airline airline) {
        airlineService.update(airline);
        return "airlineList.xhtml?faces-redirect=true";
    }
}
