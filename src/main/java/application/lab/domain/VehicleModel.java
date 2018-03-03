package application.lab.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_model_id")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne
    @JoinColumn(name = "vehicle_make_id")
    private VehicleMake vehicleMake;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleModel")
//    private List<Vehicle> vehicleList;

    public VehicleModel() {

    }

    public VehicleModel(String vehicleModelName) {
        this.setVehicleModelName(vehicleModelName);
    }


    public VehicleModel(String vehicleModelName, VehicleMake vehicleMake) {
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMake(vehicleMake);

    }



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

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }


    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

//    public List<Vehicle> getVehicleList() {
//        return vehicleList;
//    }
//
//    public void setVehicleList(List<Vehicle> vehicleList) {
//        this.vehicleList = vehicleList;
//    }


    @Override
    public String toString() {
        return  vehicleModelName;
    }
}
