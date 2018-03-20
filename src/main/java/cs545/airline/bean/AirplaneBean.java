package cs545.airline.bean;

import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class AirplaneBean {
    @Inject
    private AirplaneService airplaneService;
    private Airplane airplane = new Airplane();
    private List<Airplane> airplanes;

    @PostConstruct
    public void init() {
        airplanes = airplaneService.findAll();
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String createAirplane() {
        airplaneService.create(airplane);
        return "airplaneList.xhtml?faces-redirect=true";
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public String editAirplaneRecord(long id) {
        Airplane a = airplaneService.findById(id);
        Map<String, Object> sessionMap =
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("editAirplane", a);
        return "editAirplane.xhtml?faces-redirect=true";
    }

    public String updateAirplane(Airplane airplane) {
        airplaneService.update(airplane);
        return "airplaneList.xhtml?faces-redirect=true";
    }
}
