package org.elsys.netprog.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path("/car")
public class GameController {

    private static ArrayList <Car> cars = new ArrayList(); // hasmap for all registered cars

	@PUT
	@Path("/{colour}/{CAR_REG}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response guess(@PathParam("colour") String zone, @PathParam("CAR_REG") String carReg) throws Exception{
		if (zone.equals("blue") || zone.equals("green")){
			if(validRegistration(carReg)){
				Car car = new Car(carReg,zone);
				cars.add(car); //add the new registered car
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}

	private static boolean validRegistration(String registration){
        Pattern p = Pattern.compile("^[ETYOPAHKXCBM]{2}[0-9]{4}[ETYOPAHKXCBM]{2}$"); // regex validation pattern for the car's number

        Matcher m = p.matcher(registration);

        if(m.matches()) return true;
            return false;
	}
	
	@GET
	@Path("/{CAR_REG}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getGames(@PathParam("CAR_REG") String carReg) {
		return Response.status(200).entity(find(carReg)).build();
	}

	private Car find(String carReg) { //finds all cars with this registration and zone
		return cars.stream()
				.filter(car -> carReg.equals(car.getCarReg()) && carReg.equals(car.getZone()))
				.findAny()
				.orElse(null);
	}
}
