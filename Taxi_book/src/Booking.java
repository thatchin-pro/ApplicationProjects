public class Booking {
    private char from,to;
    private int pickUpTime,dropTime,amount,customerId,bookingId;


    public Booking(char from, char to, int pickUpTime, int dropTime, int amount, int customerId, int bookingId) {
        setAmount(amount);
        setBookingId(bookingId);
        setCustomerId(customerId);
        setDropTime(dropTime);
        setFrom(from);
        setPickUpTime(pickUpTime);
        setTo(to);
    }

    public char getFrom() {
        return this.from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return this.to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getPickUpTime() {
        return this.pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        if(pickUpTime>25||pickUpTime<0){
            throw new IllegalArgumentException("Invalid pickUpTime....!");
        }
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return this.dropTime;
    }

    public void setDropTime(int dropTime) {
        if(dropTime>25||dropTime<0){
            throw new IllegalArgumentException("Invalid dropTime....!");
        }
        this.dropTime = dropTime;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    
    
}
