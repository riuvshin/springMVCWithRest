package com.rakkaus.web.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author <a href="mailto:riuvshin@codenvy.com">Roman Iuvshin</a>
 * @version $Id: 1:02 AM 8/20/13 $
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable{

    private Long   id;
    private int    version;
    private String firstName;
    private String lastName;
    private String role;
    private DateTime   birthDate;

    public Contact() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion(){
        return this.version;
    }

    public void setVersion(int version){
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    @Column(name = "ROLE")
    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }


    @Column(name = "BIRTH_DATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getBirthDate(){
        return this.birthDate;
    }

    public void setBirthDate(DateTime birthDate){
        this.birthDate = birthDate;
    }

    public String toString(){
        return "Contact id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", birth day: " + birthDate + ", Role: " + role;
    }
}