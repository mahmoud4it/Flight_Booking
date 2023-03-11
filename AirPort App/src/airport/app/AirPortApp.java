/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.app;
import java.util.Date;

public class AirPortApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Flight flight1=new Flight(111,new Date(2020,15,12),80,30,"airbus320","paris","hong kong");
     Flight flight2=new Flight(222,new Date(2020,12,20),80,30,"airbus320","riyadh","cairo");
     Flight flight3=new Flight(333,new Date(2020,12,25),80,30,"boeng","riyadh","jeddah");
     Flight flight4=new Flight(444,new Date(2021,6,4),80,30,"airbus320","berlin","jeddah");
     Flight flight5=new Flight(555,new Date(2020,7,12),80,30,"airbus320","paris","hong kong");
     Flight flight6=new Flight(666,new Date(2021,4,23),80,30,"airbus320","paris","newyork");
     Flight flight7=new Flight(777,new Date(2021,3,4),80,30,"airbus320","riyadh","hong kong");
     
     Airline airline=new Airline();
     airline.addFlight(flight1);
     airline.addFlight(flight2);
     airline.addFlight(flight3);
     airline.addFlight(flight4);
     airline.addFlight(flight5);
     airline.addFlight(flight6);
     airline.addFlight(flight7);
     
     Passenger p1=new Passenger(123456,"rayan",new Date(1990,1,30),"Egypt");
     airline.addPassenger(p1,flight1);
     
     Passenger p2=new Passenger(234237,"omar",new Date(1990,1,1),"Egypt");
     airline.addPassenger(p2,flight1);
     
     Passenger p3=new Passenger(545222,"ahmed",new Date(1985,5,23),"Egypt");
     airline.addPassenger(p3,flight2);
     
     Passenger p4=new Passenger(467888,"adnan",new Date(1980,2,12),"Egypt");
     airline.addPassenger(p4,flight2);

     Passenger p5=new Passenger(54678,"ali",new Date(1989,9,12),"Egypt");
     airline.addPassenger(p5,flight2);
     
     
     Pilot pilot1=new Pilot("n14234","omar qahtani",new Date(1980,1,1),"saudi arabia");
     Pilot pilot2=new Pilot("n67834","abdullah ahmed",new Date(1990,12,1),"saudi arabia");
     Pilot pilot3=new Pilot("n13464","rayan rubayii",new Date(1991,1,6),"saudi arabia");
     
     airline.addPilot(pilot1, flight1);
     airline.addPilot(pilot2, flight2);
     airline.addPilot(pilot3, flight3);
     
     airline.display();
     
     airline.saveInTextFile("AitPort Information.txt");            
    }
    
}
