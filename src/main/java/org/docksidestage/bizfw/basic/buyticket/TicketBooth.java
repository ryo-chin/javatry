/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

// TODO hakiba javadocよろしく by jflute (2019/10/03)
/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int TWO_DAY_MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO hakiba これ、oneDayの方をquantityのままにするのが迷いどころじゃない？ by jflute (2019/10/03)
    private int quantity = MAX_QUANTITY;
    private int twoDayQuantity = TWO_DAY_MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public OneDayTicket buyOneDayPassport(int handedMoney) {
        // TODO hakiba 修行++: はちゃめちゃでもいいから、この4行をbuyTwoDayPassport()と再利用してみよう by jflute (2019/10/03)
        checkSoldOut(quantity);
        checkSufficient(handedMoney, ONE_DAY_PRICE);
        --quantity;
        recordSalesProceeds(ONE_DAY_PRICE);
        return new OneDayTicket(TicketType.ONE_DAY, ONE_DAY_PRICE);
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        checkSoldOut(twoDayQuantity);
        checkSufficient(handedMoney, TWO_DAY_PRICE);
        --twoDayQuantity;
        recordSalesProceeds(TWO_DAY_PRICE);
        return new TicketBuyResult(new MultipleDaysTicket(TicketType.TWO_DAY, 2, TWO_DAY_PRICE), handedMoney - TWO_DAY_PRICE);
    }

    private void checkSoldOut(int quantity) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void checkSufficient(int handedMoney, int twoDayPrice) {
        if (handedMoney < twoDayPrice) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    private void recordSalesProceeds(int oneDayPrice) {
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + oneDayPrice;
        } else {
            salesProceeds = oneDayPrice;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public int getTwoDayQuantity() {
        return twoDayQuantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
