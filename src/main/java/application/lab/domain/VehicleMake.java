package application.lab.domain;

import application.lab.domain.VO.VehicleVO;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_make_id")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleMake")
//    private List<VehicleModel> vehicleModelList;



    public VehicleMake() {

    }

    public VehicleMake(String vehicleMakeName) {
        this.setVehicleMakeName(vehicleMakeName);
    }

//    public void updateMake(VehicleVO vo) {
//        vehicleMakeName=vo.getNewVehicleMake();
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

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

//    public List<VehicleModel> getVehicleModelList() {
//        return vehicleModelList;
//    }
//
//    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
//        this.vehicleModelList = vehicleModelList;
//    }


    @Override
    public String toString() {
        return vehicleMakeName;
    }
}
