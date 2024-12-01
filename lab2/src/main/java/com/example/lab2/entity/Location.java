package com.example.lab2.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Location
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String city;

    @Column
    private String countryCode;

    @Column
    private float latitude;

    @Column
    private float longitude;

    @OneToMany(mappedBy = "location", orphanRemoval = true)
    private List<Measurement> measurements;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCountryCode(){
        return countryCode;
    }
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    public float getLatitude(){
        return latitude;
    }
    public void setLatitude(float latitude){
        this.latitude = latitude;
    }
    public float getLongitude(){
        return longitude;
    }
    public void setLongitude(float longitude){
        this.longitude = longitude;
    }
    public List<Measurement> getMeasurements(){
        return measurements;
    }
    public void setMeasurements(List<Measurement> measurements){
        this.measurements = measurements;
    }

}
