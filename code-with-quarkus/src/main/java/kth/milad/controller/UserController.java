package kth.milad.controller;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import kth.milad.model.Doctor;
import kth.milad.model.Patient;
import kth.milad.model.User;
import java.util.List;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/search")
public class UserController {


    @GET
    @Path("/patient")
    public Uni<List<Patient>> getPatientByName(@QueryParam("name") String name1) {
        System.out.println(name1 + "********");
        Uni<List<Patient>> u = Patient.find("name like ?1", name1+"%").list();
        System.out.printf(u.toString());
        return u;
    }

    @GET
    @Path("/doctor")
    public Uni<List<Doctor>> getDoctorByName(@QueryParam("name") String name1) {
        System.out.println(name1 + "********");
        Uni<List<Doctor>> u = Doctor.find("name like ?1", name1+"%").list();
        System.out.printf(u.toString());
        return u;
    }
}