package application.lab.controllers;

import application.lab.domain.VO.VehicleVO;
import application.lab.domain.Vehicle;
import application.lab.domain.VehicleMake;
import application.lab.domain.VehicleModel;
import application.lab.services.VehicleMakeService;
import application.lab.services.VehicleModelService;
import application.lab.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    private Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/adminHome";
    }



    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());



        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model) {
        logVehicleVO(vehicleVO);

        saveVehicleDetailsFromVO(vehicleVO);


        boolean success = true;
        if(success) {
            model.addAttribute("successAlert", "visible");
        } else {
            model.addAttribute("errorAlert", "visible");
        }

        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());
        return "admin/vehicle/vehicle_add";
    }



    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model) {

        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        for(Vehicle vehicle : vehicleList) {
            VehicleModel vehicleModel = vehicleModelService.getById(vehicle.getId());
            VehicleMake vehicleMake = vehicleMakeService.getById(vehicleModel.getId());
        }


        model.addAttribute("vehicleList", vehicleList );

        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);

        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());

        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicle", vehicle);

        return "/admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update/{id}", method = RequestMethod.POST)
    public String vehicleUpdate(@PathVariable int id, VehicleVO vehicleVO, Model model) {


        updateVehicleDetailsFromVO(vehicleVO, id);

        logVehicleVO(vehicleVO);


        boolean success = true;
        if(success) {
            model.addAttribute("successAlert", "visible");
        } else {
            model.addAttribute("errorAlert", "visible");
        }

        model.addAttribute("vehicleVO", new VehicleVO());

        model.addAttribute("makeList",  vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("modelList", vehicleModelService.listAllVehicleModels());

        return "redirect:/admin/vehicle/edit/" + id;


    }

    private void updateVehicleDetailsFromVO(VehicleVO vehicleVO, int id) {
        Vehicle updateVehicle = vehicleService.getVehicleById(id);

        updateVehicle.setYear(vehicleVO.getNewVehicleYear());
        updateVehicle.setLicensePlate(vehicleVO.getNewVehicleLicensePlate());
        updateVehicle.setVIN(vehicleVO.getNewVehicleVIN());
        updateVehicle.setColor(vehicleVO.getNewVehicleColor());


        updateVehicle.setVehicleModel(vehicleModelService.getById(vehicleVO.getNewVehicleModel()));


        vehicleService.saveVehicle(updateVehicle);


    }

    private void saveVehicleDetailsFromVO(VehicleVO vehicleVO) {


        VehicleModel newVehicleModel = vehicleModelService.getById(vehicleVO.getNewVehicleModel());



        Vehicle newVehicle = new Vehicle(vehicleVO.getNewVehicleYear(), vehicleVO.getNewVehicleLicensePlate(),
                vehicleVO.getNewVehicleVIN(), vehicleVO.getNewVehicleColor(),newVehicleModel);
        vehicleService.saveVehicle(newVehicle);

    }

    private void logVehicleVO(VehicleVO vehicleVO) {
        log.info("New Vehicle: " + vehicleVO.getNewVehicleMake() + " " + vehicleVO.getNewVehicleModel() + " "
        + vehicleVO.getNewVehicleYear() + " " + vehicleVO.getNewVehicleLicensePlate() + " " +
        vehicleVO.getNewVehicleVIN() + " " + vehicleVO.getNewVehicleColor());
    }






}
