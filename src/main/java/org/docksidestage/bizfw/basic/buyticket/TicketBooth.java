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

import java.util.HashMap;
import java.util.Map;

// TODO done hakiba javadocよろしく by jflute (2019/10/03)
/**
 * チケット売り場
 * <pre>
 * o チケット種別ごとに在庫を保持している
 * o 各種チケット在庫や売り上げはチケット売り場それぞれで保有している
 * <pre>
 *
 * @author jflute
 * @author hakiba
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int ONE_DAY_MAX_QUANTITY = 10;
    private static final int TWO_DAY_MAX_QUANTITY = 10;
    private static final int FOUR_DAY_MAX_QUANTITY = 10;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // done hakiba これ、oneDayの方をquantityのままにするのが迷いどころじゃない？ by jflute (2019/10/03)
    // 別々のQuantityとして管理しようかなと思っているので一旦変数名を変えます。 by hakiba
    private Map<TicketType, Integer> ticketStockHolder = new HashMap<>();
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
        ticketStockHolder.put(TicketType.ONE_DAY, ONE_DAY_MAX_QUANTITY);
        ticketStockHolder.put(TicketType.TWO_DAY, TWO_DAY_MAX_QUANTITY);
        ticketStockHolder.put(TicketType.FOUR_DAY, FOUR_DAY_MAX_QUANTITY);
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        // TODO done hakiba 修行++: はちゃめちゃでもいいから、この4行をbuyTwoDayPassport()と再利用してみよう by jflute (2019/10/03)
        return new TicketBuyResult(new OneDayTicket(), buyPassport(TicketType.ONE_DAY, handedMoney));
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        TicketType ticketType = TicketType.TWO_DAY;
        return new TicketBuyResult(new MultipleDaysTicket(ticketType), buyPassport(ticketType, handedMoney));
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        TicketType ticketType = TicketType.FOUR_DAY;
        return new TicketBuyResult(new MultipleDaysTicket(ticketType), buyPassport(ticketType, handedMoney));
    }

    private int buyPassport(TicketType ticketType, int handedMoney) {
        Integer quantity = ticketStockHolder.get(ticketType);
        checkSoldOut(quantity);
        checkSufficient(handedMoney, ticketType.getPrice());
        ticketStockHolder.put(ticketType, quantity - 1);
        recordSalesProceeds(ticketType.getPrice());
        return handedMoney - ticketType.getPrice();
    }

    private void checkSoldOut(int quantity) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void checkSufficient(int handedMoney, int price) {
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    private void recordSalesProceeds(int price) {
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
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
    public int getOneDayQuantity() {
        return ticketStockHolder.get(TicketType.ONE_DAY);
    }

    public int getTwoDayQuantity() {
        return ticketStockHolder.get(TicketType.TWO_DAY);
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
