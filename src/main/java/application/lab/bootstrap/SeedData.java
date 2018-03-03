package application.lab.bootstrap;

import application.lab.domain.Vehicle;
import application.lab.domain.VehicleMake;
import application.lab.domain.VehicleModel;
import application.lab.services.VehicleMakeService;
import application.lab.services.VehicleModelService;
import application.lab.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateVehicleAndVehicleTypes();
    }

    private void generateVehicleAndVehicleTypes() {

        VehicleMake Ford = new VehicleMake("Ford");
        VehicleMake Toyota = new VehicleMake("Toyota");
        VehicleMake Kia = new VehicleMake("Kia");

        List<VehicleMake> makeList = new ArrayList<>();
        makeList.add(Ford);
        makeList.add(Toyota);
        makeList.add(Kia);

        VehicleModel Explorer = new VehicleModel("Explorer", Ford);
        VehicleModel Taurus = new VehicleModel("Taurus", Ford);
        VehicleModel Prius = new VehicleModel("Prius", Toyota);
        VehicleModel Rio = new VehicleModel("Rio", Kia);
        VehicleModel Corolla = new VehicleModel("Corolla", Toyota);

        List<VehicleModel> modelList = new ArrayList<>();
        modelList.add(Explorer);
        modelList.add(Taurus);
        modelList.add(Prius);
        modelList.add(Rio);
        modelList.add(Corolla);


        vehicleMakeService.saveVehicleMakeList(makeList);
        vehicleModelService.saveVehicleModelList(modelList);


        Vehicle ford1 = new Vehicle(2000, "asd-123", "12312356sd", "Blue", Explorer);



        vehicleService.saveVehicle(ford1);




    }




}
