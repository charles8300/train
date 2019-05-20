package services;

import model.User;
import repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {
    @Inject
    UserRepository userRepository;

    @GET
    public Response getAll() {
        userRepository.create(dummyUser());
        userRepository.create(dummyUser2());

        return Response.ok(userRepository.getAll()).build();
    }

    @POST
    public Response create(User user) {
        userRepository.create(user);
        return Response.ok().build();
    }

    private User dummyUser(){
        return User.builder()
                .firstName("Janusz")
                .lastName("Kowalski")
                .email("janusz.kowalski@wp.pl")
                .address("Mickiewicza 4, 00-100 Kielce")
                .phone(12312312)
                .password("kokaina_ma_rodzina")
                .build();
    }

    private User dummyUser2(){
        return User.builder()
                .firstName("Grazyna")
                .lastName("Kowalska")
                .email("grazyna.kowalski@wp.pl")
                .address("Mickiewicza 4, 00-100 Kielce")
                .phone(12312313)
                .password("zdradzam_meza")
                .build();
    }

}
