import java.util.*;

public class Taxi {
    int id;
    char currentPoint = 'A';
    int amountEarned = 0;

    List<Booking> bookings = new ArrayList<>();

    public Taxi(int id){
        this.id=id;
    }    

    public boolean isAvailable(int requestTime){
        if(bookings.isEmpty()){
            return true;
        }
        Booking lastBooking = bookings.get(bookings.size()-1);
        if(lastBooking.getDropTime()<=requestTime){
            return true;
        }
        else{
            return false;
        }
    }

    public int calculateEarning(char from,char to){
        int distance = Math.abs(to-from)*15;
        return 100 + ((distance-5)*10);
    }

    public void addBooking(Booking booking){
        currentPoint = booking.getTo();
        amountEarned += booking.getAmount();
        bookings.add(booking);
    }


}
