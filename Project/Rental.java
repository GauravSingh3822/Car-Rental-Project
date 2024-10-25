package Project;
public class Rental{
    private Car car;
    private Custmer customer;
    private int days;
    public Rental(Car car,Custmer customer,int days){
        this.car=car;
        this.customer=customer;
        this.days=days;
    }
    public Car getCar(){
        return car;
    }
    public Custmer getCustomer(){
        return customer;
    }
    public int getDays(){
        return days;
    }
}
