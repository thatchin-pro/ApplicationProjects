package pojo;

public abstract class TradeAccount {
    private String id;

    //constructor
    public TradeAccount(String id){
        this.id=id;
    }

    //getter and setter
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //clone

    public abstract TradeAccount clone();


}