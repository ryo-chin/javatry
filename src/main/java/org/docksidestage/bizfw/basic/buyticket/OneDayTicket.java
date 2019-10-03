package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author hakiba
 */
public class OneDayTicket implements Ticket {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final TicketType type;
    private boolean alreadyIn;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public OneDayTicket() {
        this.type = TicketType.ONE_DAY;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    @Override
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + getDisplayPrice());
        }
        alreadyIn = true;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    public int getDisplayPrice() {
        return type.getPrice();
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    public TicketType getType() {
        return type;
    }
}
