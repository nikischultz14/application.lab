package application.lab.domain.VO;

public class VehicleVO {

    private Integer newVehicleMake;
    private Integer newVehicleModel;
    private Integer newVehicleYear;
    private String newVehicleLicensePlate;
    private String newVehicleVIN;
    private String newVehicleColor;


    private String[] newVehicleArray;

    public VehicleVO() {

    }

//path needs to correspond to vo objects





    public String[] getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(String[] newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }

    public Integer getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(Integer newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public Integer getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(Integer newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public Integer getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(Integer newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleVIN() {
        return newVehicleVIN;
    }

    public void setNewVehicleVIN(String newVehicleVIN) {
        this.newVehicleVIN = newVehicleVIN;
    }

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }
}
