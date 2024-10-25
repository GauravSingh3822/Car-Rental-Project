package Project;
import java.util.*;
public class Car{
    private String Car_ID;
    private String Car_Model;
    private String Car_Brand;
    private double Car_Price_Per_day;
    private boolean isAvailable;
    public Car(String Car_Id,String Car_Model,String Car_Brand,double Car_Price_Per_day){
        this.Car_ID=Car_Id;
        this.Car_Model=Car_Model;
        this.Car_Brand=Car_Brand;
        this.Car_Price_Per_day=Car_Price_Per_day;
        this.isAvailable=true;
    }
    public String getCar_ID(){
        return Car_ID;
    }
    public String getCar_Model(){
        return Car_Model;
    }
    public String getCar_Brand(){
        return  Car_Brand;
    }
    public double Calculate_Price(int rentalDays){
        return Car_Price_Per_day*rentalDays;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable=false;
    }
    public void returnCar(){
        isAvailable=true;
    }
}

