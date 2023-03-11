/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Airline {
    
     private final List flights = new ArrayList<>(); //this is a collection of flights
     
     public Airline() {}

    public List getFlights() {
        return flights;
    }
    
    //checking if a specific flight is exists or not
    public boolean flight_isExists(Flight flight) {
        boolean flightExist = false;
        if (!flights.isEmpty()) {
            for (Object f : flights) {
                if (f.equals(flight)) {
                    flightExist = true;
                    break;
                }
            }
        }
        return flightExist;
    }

    //add a flight to the flights collection inside Airline class
    public void addFlight(Flight flight) {
        if (!flight_isExists(flight)) {
            flights.add(flight);
            System.out.println("Flight has been Added succefully.");
        } else {
            System.out.println("Flight number: " + flight.getNumber() + " is already exist.");
        }
    }

    //checking if a specific pilot is exists or not
    public boolean pilot_is_exists(Pilot newPilot) {
        boolean pilotExist = false;
        Flight fl;
        for (Object flight : flights) {
            fl = (Flight) flight;
            if (fl.getPilot() != null && fl.getPilot().equals(newPilot)) {
                pilotExist = true;
                System.out.println("Pilot with id: " + newPilot.getId() + " exist in flight number: " + fl.getNumber());
                break;
            }
        }
        return pilotExist;
    }

    //add a pilot to a specific flight inside the flights collection
    public void addPilot(Pilot pilot, Flight toFlight) {
        if (toFlight != null && flights.contains(toFlight)) {
            if (!pilot_is_exists(pilot)) {
                toFlight.setPilot(pilot);
                System.out.println("Pilot with id: " + pilot.getId() + " added to flight number: " + toFlight.getNumber());
            }
        } else {
            System.out.println("Flight doesn't exist");
        }
    }

    //add a passenger to a specific flight inside the flights collection
    public void addPassenger(Passenger passenger, Flight toFlight) {
        if (toFlight != null && flights.contains(toFlight)) {
            if (toFlight.getPassengers().size() < toFlight.getMaximumPassengers()) {
                if (!toFlight.isExists(passenger)) {
                    toFlight.getPassengers().add(passenger);
                    System.out.println("Passenger with passport number: " + passenger.getPassportNumber() + " added to flight number: " + toFlight.getNumber());
                }
            } else {
                System.out.println("Maximum number of passengers has been reached for flight number: " + toFlight.getNumber());
            }
        } else {
            System.out.println("Flight doesn't exist");
        }
    }
    
    //remove a specific passenger from a specific flight in flights collection
    public boolean removePassenger(Passenger passenger, Flight flight) {
        if (flight != null && flights.contains(flight)) {
        
        if (flight.getPassengers().size() > flight.getMinimumPassengers()) {
            if (flight.isExists(passenger)) {
                flight.getPassengers().remove(passenger);
                System.out.println("Passnger has been removed succefully");
                return true;
            } else {
                System.out.println("Passnger with passport number: " + passenger.getPassportNumber() + " does not exist");
                return false;
            }
        } else {
            System.out.println("you can not remove passenger, because Minimum number of passengers has been reached.");
            return false;
        }
        }
        else{
            System.out.println("Flight doesn't exist");
            return false;
        }
    }

    //gets the average passengers per flight
    public void averagePassengersPerFlight(Date date) {
        int passengersCount = 0;
        int flightsCount = 0;
        double average = 0.0;
        Flight fl;
        for (Object flight : flights) {
            fl = (Flight) flight;
            if (fl.getDate().equals(date)) {
                flightsCount++;
                passengersCount += fl.getPassengers().size();
            }
        }
        System.out.println("Total passengers in this flight is : " + passengersCount);
        if (passengersCount > 0 && flightsCount > 0) {
            average = passengersCount / flightsCount;
            System.out.println("Average passengers per flight for the date(" + date + "): " + average);
        } else {
            System.out.println("Average passengers per flight for the date(" + date + "): " + 0.0);
        }
    }

    //displays all fights, with all the information of it
    public void display() {
        Flight fl;
        final List dates = new ArrayList<>();
        for (Object flight : flights) {
            fl = (Flight) flight;
            if (!dates.contains(fl.getDate())) {
                dates.add(fl.getDate());
            }
        }
        Collections.sort(dates);
        for (Object date : dates) {
            System.out.print(date + ": ");
            final List numbers = new ArrayList<>();
            for (Object flight : flights) {
                fl = (Flight) flight;
                if (fl.getDate().equals(date)) {
                    numbers.add(fl.getNumber());
                }
            }
            Collections.sort(numbers);
            for (Object number : numbers) {
                System.out.print("flight No." + number + " ");
            }
            System.out.print("\n");
        }
    }

    //saves the flights information in a text file inside the same folder of the project
    public void saveInTextFile(String fileName) {
        try {
            final FileWriter writer = new FileWriter(fileName);
            for (Object flight : flights) {
                writer.write(flight.toString());
                writer.write("\n");
            }
            writer.close();
            System.out.println("Saved successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Number of flights is : " + flights.size();
    }
}
    

