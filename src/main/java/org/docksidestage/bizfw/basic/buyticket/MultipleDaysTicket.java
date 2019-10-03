package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author hakiba
 */
public class MultipleDaysTicket implements Ticket {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final TicketType type;
    private int usedDays = 0;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MultipleDaysTicket(TicketType type) {
        this.type = type;
    }
    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======

    @Override
    public void doInPark() {
        if (isAlreadyUsedUntilUsableDays()) {
            throw new IllegalStateException(String.format("Already used until usable days : usableDays=%s, usedDays=%s", getUsableDays(), getUsedDays()));
        }
        ++usedDays;
    }

    private boolean isAlreadyUsedUntilUsableDays() {
        return type.getUsableDays() <= usedDays;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    public int getDisplayPrice() {
        return type.getPrice();
    }

    public int getUsableDays() {
        return type.getUsableDays();
    }

    public int getUsedDays() {
        return usedDays;
    }

    public TicketType getType() {
        return type;
    }
}
