package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author hakiba
 */
public class MultipleDaysTicket implements Ticket {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice;
    private final TicketType type;
    private final int usableDays;
    private int usedDays = 0;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MultipleDaysTicket(TicketType type, int usableDays, int displayPrice) {
        this.type = type;
        this.usableDays = usableDays;
        this.displayPrice = displayPrice;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    @Override
    public void doInPark() {
        if (isAlreadyOverLimit()) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        ++usedDays;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isAlreadyOverLimit() {
        return usableDays <= usedDays;
    }

    public TicketType getType() {
        return type;
    }
}
