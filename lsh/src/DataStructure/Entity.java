/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.io.Serializable;

/**
 *
 * @author JanithaT
 */
public class Entity implements Serializable{

   private String recordID;
   private String firstName;
   private String lastName;
   private String city;
   
   public Entity(String rID,String Fname,String LName,String City){
       recordID = rID;
       firstName = Fname;
       lastName = LName;
       city = City;
       
   }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
   
    //modify this!!!!
   @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + getFirstName().length() + getLastName().length();
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            //System.out.println("Object is null");
            return false;
        }
        if (getClass() != obj.getClass()) {
            //System.out.println("not same class");
            return false;
        }
        final Entity other = (Entity) obj;
//        System.out.println(other.getRecordID() + " Other " + getRecordID() );
//        System.out.println(other.getFirstName()+ " Other " + getFirstName() + !(other.getFirstName() == getFirstName()));
//        System.out.println(other.getLastName()+ " Other " + getLastName() + !(other.getLastName()== getLastName()));
//        System.out.println(other.getCity()+ " Other " + getCity() + !(other.getCity()== getCity()));
        if (!(other.getFirstName() == null ? getFirstName() == null : other.getFirstName().equals(getFirstName()))
                || !(other.getLastName() == null ? getLastName() == null : other.getLastName().equals(getLastName()))
                || !(other.getCity() == null ? getCity() == null : other.getCity().equals(getCity()))) {
            //System.out.println("Attributes are different");
            return false;
        }
        return true;
    }
    
}
