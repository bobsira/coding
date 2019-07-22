package Faith;

public class Vehicle { // base class

    //instance variables
    protected String  color;
    private int wheel;
    public int chairs;

    //static varible






    public int getWheel() {  //getter
        return wheel;
    }

    public void setWheel(int wheel) { //setter
        this.wheel = wheel;
    }




    //methods
    public void move(){  //function definition
        System.out.println("Vehicle is moving");
    }

    public void stop(){
        System.out.println("Stopped");
    }

    Vehicle(){} // default constructor

    //constructor used to first initialize the class when it is created
    Vehicle(int wheel, int chairs) //parameters
    {
        this.wheel = wheel;
        this.chairs = chairs;
    }

//    public class Car extends Vehicle { //derived class
//
//    }


    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();  //object
        Vehicle vehicle1 = new Vehicle(4,4); // arguments

        vehicle.move();
        System.out.println(vehicle.chairs);
        System.out.println(vehicle.wheel);

        System.out.println();

        vehicle1.move(); //fuction calling
        System.out.println(vehicle1.chairs);
        System.out.println(vehicle1.wheel);
    }
}
