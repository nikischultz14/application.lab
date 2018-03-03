package application.lab.domain;

import application.lab.domain.VO.VehicleVO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Version
    private Integer version;

    private Integer year;
    private String licensePlate;
    private String VIN;
    private String color;

    @ManyToOne
    @JoinColumn(name="vehicle_model_id")
    private VehicleModel vehicleModel;



    public Vehicle() {

    }

    public Vehicle(Integer year, String licensePlate, String VIN, String color, VehicleModel vehicleModel) {
       this.setYear(year);
       this.setLicensePlate(licensePlate);
       this.setVIN(VIN);
       this.setColor(color);
       this.setVehicleModel(vehicleModel);


    }

//    public void updateVehicle(VehicleVO vo) {
//        year=vo.getNewVehicleYear();
//        licensePlate=vo.getNewVehicleLicensePlate();
//        VIN=vo.getNewVehicleVIN();
//        color=vo.getNewVehicleColor();
//
//    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
