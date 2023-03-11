/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.app;
import java.util.Date;

public class Pilot extends Person{
    private String id;

    public Pilot(String id, String name, Date dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //checks if 2 pilot are equals
    @Override
    public boolean equals(Object o) {
        Pilot p = (Pilot) o;
        if(id == p.getId())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Id: " + id;
    }
}
