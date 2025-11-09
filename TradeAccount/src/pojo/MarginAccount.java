package pojo;

import java.math.BigDecimal;

public class MarginAccount extends TradeAccount {

    private BigDecimal margin;

    //constructor
    public MarginAccount(String id,BigDecimal margin){
        super(id);
        setMargin(margin);
    }

    //getter and setter

    public BigDecimal getMargin() {
        return this.margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    @Override
    public TradeAccount clone(){
        return new MarginAccount(super.getId(),this.margin);
    }


}
