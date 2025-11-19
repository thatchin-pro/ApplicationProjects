import java.util.*;

public class Main{
    static Scanner scan = new Scanner(System.in);

    static List<Taxi> taxis = new ArrayList<>();

    static int customerId = 1;
    
    public static void main(String[] args){
        System.out.print("Enter no of Taxi:");
        int noOfTaxi = scan.nextInt();
        initializeTaxis(noOfTaxi);    

        while(true){
            System.out.println("\n1.Book Taxi\n2.Display Taxi Details\n3.Exit");
            System.out.print("Enter Your Choice:");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    booktaxi();
                    break;
                case 2:
                    displaytaxi();
                    break;
                case 3:
                    System.out.println("Exiting.....!!!");
                    return;
                default:    
                    System.out.println("Invalid Choice...!!!");
                    break;
            }
        }
    }

    public static void initializeTaxis(int noOfTaxi){
        for(int i=1;i<=noOfTaxi;i++){
            taxis.add(new Taxi(i));
        }
    }

    public static void booktaxi(){
        customerId = customerId++;
        System.out.print("Enter Pickup Point:");
        char from = scan.next().toUpperCase().charAt(0);
        System.out.print("Enter Drop Point:");
        char to = scan.next().toUpperCase().charAt(0);
        System.out.print("Enter Pickup Time:");
        int pickUpTime = scan.nextInt();

        Taxi selectedTaxi = nearestTaxi(from,pickUpTime);

        if(selectedTaxi ==null){
            System.out.println("No Taxis Availabe");
            return;
        }

        int dropTime = pickUpTime + Math.abs(from-to);
        int amount = selectedTaxi.calculateEarning(from, to);
        int bookingId = selectedTaxi.bookings.size()+1;


        Booking booking = new Booking(from,to,pickUpTime,dropTime,amount,customerId,bookingId);
        selectedTaxi.addBooking(booking);
        System.out.println("Taxi - " + selectedTaxi.id + " is Allocated.");

    }


    public static Taxi nearestTaxi(char from,int time){
        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for(Taxi taxi:taxis){
            if(taxi.isAvailable(time)){
                int distance = Math.abs(from-taxi.currentPoint);
                
                if(distance<minDistance || (distance==minDistance && selectedTaxi.amountEarned>taxi.amountEarned)){
                    selectedTaxi = taxi;
                    minDistance = distance;
                }
            }
        }
        return selectedTaxi;
    }

    public static void displaytaxi(){
        for(Taxi taxi:taxis){
            System.out.println("Taxi-1 "+ taxi.id+" Total Earning: "+taxi.amountEarned);
            System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s","Booking ID","Customer ID","From","to","PickUpTime","DropTime","Amount");
            System.out.println();
            for(Booking booking: taxi.bookings){
                System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s",booking.getBookingId(),booking.getCustomerId(),booking.getFrom(),booking.getTo(),booking.getPickUpTime(),booking.getDropTime(),booking.getAmount());
            }
            System.out.println();
        }

    }


}