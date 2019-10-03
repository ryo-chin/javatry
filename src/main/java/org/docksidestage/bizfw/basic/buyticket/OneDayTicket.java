package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author hakiba
 */
public class OneDayTicket implements Ticket {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice;
    private final TicketType type;
    private boolean alreadyIn;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public OneDayTicket(int displayPrice) {
        this.type = null;
        this.displayPrice = displayPrice;
    }
    public OneDayTicket(TicketType type, int displayPrice) {
        this.type = type;
        this.displayPrice = displayPrice;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    @Override
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    public TicketType getType() {
        return type;
    }
}
