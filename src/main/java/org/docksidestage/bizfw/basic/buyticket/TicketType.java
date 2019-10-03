package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author hakiba
 */
public enum TicketType {
    ONE_DAY(7400, 1),
    TWO_DAY(13200, 2);

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    TicketType(int price, int usableDays) {
        this.price = price;
        this.usableDays  = usableDays;
    }

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int price;
    private final int usableDays;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========

    public int getPrice() {
        return price;
    }

    public int getUsableDays() {
        return usableDays;
    }
}
