/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.app;

import java.util.Date;

public class Passenger extends Person{
     private int passportNumber;

    public Passenger(int passportNumber, String name, Date dateOfBirth, String nationality) {
        this.passportNumber = passportNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    //checks if 2 passengers are equals
    @Override
    public boolean equals(Object o) {
        Passenger p = (Passenger) o;
        if(passportNumber == p.passportNumber)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", passport number: " + passportNumber;
    }
    
}
