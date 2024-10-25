package Project;
import java.util.*;
import java.util.List;
public class Car_Rental_System {
    protected List<Car> cars;
    protected List<Custmer> customers;
    protected List<Rental> rentals;

    public Car_Rental_System() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Custmer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Custmer customer, int days) {
        if (car.isAvailable() == true) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent...");
        }
    }

    public void returnCar(Car car) {
        Rental rentaltoremove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentaltoremove = rental;
                break;
            }
        }
        if (rentaltoremove != null) {
            rentals.remove(rentaltoremove);
        } else {
            System.out.println("Car was not rented....");
        }
        car.returnCar();
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=======Car Rental System=====");
            System.out.println("1].Rent a Car...");
            System.out.println("2].Return Rented Car....");
            System.out.println("3].Exist...");
            System.out.println();
            System.out.println("Enter your Choice....");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("====Rent a Car ====");
                System.out.print("Enter Your Name:");
                String customerName=sc.nextLine();

                // Check car Available or Not
                System.out.println("====Available Cars :");
                for(Car car:cars) {
                    if (car.isAvailable() == true) {
                        System.out.println(car.getCar_ID() + "-" + car.getCar_Brand() + "-" + car.getCar_Model());
                    }
                }
                System.out.println();
                System.out.println("Enter the Car ID you want to rent...");

                    // Car_ID
                    String carID=sc.nextLine();

                    System.out.println("Enter the number of Days for rental..");
                    int rentalDay=sc.nextInt();
                    sc.nextLine();

                    //Customer Details
                    Custmer newCustomer=new Custmer("CUS"+(customers.size()+1),customerName);
                    addCustomer(newCustomer);

                    // Car Selection
                    Car selectedCar=null;
                    for(Car car:cars){
                        if(car.getCar_ID().equals(carID) && car.isAvailable()==true){
                            selectedCar=car;
                            break;
                        }
                    }
                    if(selectedCar!=null){
                        double totalprice= selectedCar.Calculate_Price(rentalDay);
                        System.out.println("=== Rental Information ===");
                        System.out.println("Custmoer ID:"+newCustomer.getCustmor_id());
                        System.out.println("Customer Name:"+newCustomer.getCustmor_name());
                        System.out.println("Car:"+selectedCar.getCar_Brand()+" "+selectedCar.getCar_Model());
                        System.out.println("Rental Days :"+rentalDay);
                        System.out.printf("Total Price :$%.2f%n",totalprice);
                        System.out.println("confirm rent Y/N");
                        String confirm=sc.nextLine();
                        if(confirm.equalsIgnoreCase("Y")){
                            rentCar(selectedCar,newCustomer,rentalDay);
                            System.out.println("Car rented Successfull...");
                        }else{
                            System.out.println("Rental Canceled");
                        }
                    }else {
                        System.out.println("Invalid Car Selection or Car not Available for rent...");
                    }
            } else if (choice==2) {
                System.out.println("==== Return Rented Car ====");
                System.out.println("Enter Car ID :");
                String carId=sc.nextLine();

                Car carToreturn=null;
                for(Car car:cars){
                    if(car.getCar_ID().equals(carId) && car.isAvailable()==false){
                        carToreturn=car;
                        break;
                    }
                }
                if(carToreturn!=null){
                    Custmer custmer=null;
                    for(Rental rental:rentals){
                        if(rental.getCar()==carToreturn){
                            custmer=rental.getCustomer();
                            break;
                        }
                    }
                    if (custmer!=null){
                        returnCar(carToreturn);
                        System.out.println("Car returned Succesfully by "+ custmer.getCustmor_name());
                    }
                    else{
                        System.out.println("Car was not rented or rental information missing..");
                    }
                }else{
                    System.out.println("Invalid Choice.Please Enter Valid Choice");
                }

            } else if (choice==3) {
                break;
            }
            else {
                System.out.println("Enter Valid Choice...");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Thankyou for using Car Rental System");
     }
}
