/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {
    private final List passengers = new ArrayList<>();

    private int number;
    private Pilot pilot;
    private Date date;
    private int maximum_Passengers;
    private int minimum_Passengers;
    private String airplaneType;
    private String from;
    private String to;

    public Flight(int number, Date date, int maximum_Passengers, int minimum_Passengers, String airplaneType, String from, String to) {
        this.number = number;
        this.date = date;
        this.maximum_Passengers = maximum_Passengers;
        this.minimum_Passengers = minimum_Passengers;
        this.airplaneType = airplaneType;
        this.from = from;
        this.to = to;
    }

    Flight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getPassengers() {
        return passengers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaximumPassengers() {
        return maximum_Passengers;
    }

    public void setMaximumPassengers(int maximum_Passengers) {
        this.maximum_Passengers = maximum_Passengers;
    }

    public int getMinimumPassengers() {
        return minimum_Passengers;
    }

    public void setMinimumPassengers(int minimum_Passengers) {
        this.minimum_Passengers = minimum_Passengers;
    }

    public String getAirplaneType() {
        return airplaneType;
    }
    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
 
    //this function checks if a spicific passenger is already exists in the flight
     public boolean isExists(Passenger passenger) {
        boolean isExist = false;
        for (Object p : passengers) {
            if (p.equals(passenger)) {
                isExist = true;
                System.out.println("Passenger with the passport number: " + passenger.getPassportNumber() + " is already exists in the flight number: " + number);
                break;
            }
        }
        return isExist;
    }



    //prints the information of all passengers inside the flight
    public void printPassengersList() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers in the flight.");
        } else {
            for (Object p : passengers) {
                System.out.println(p.toString());
            }
        }
    }

    //checks if 2 flights are equals
    @Override
    public boolean equals(Object o) {
        Flight f = (Flight) o;
        if(number==f.number || date == f.date)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        String pilotInfo = "No pilot yet";
        if (pilot != null) {
            pilotInfo = pilot.toString();
        }
        return "Flight Number: " + number + ", Pilot: " + pilotInfo + ", Date: " + date + ", Airplane type: " + airplaneType + ", from : " + from + ", To: " + to + ", Number of passengers: " + passengers.size();
    }   
}
