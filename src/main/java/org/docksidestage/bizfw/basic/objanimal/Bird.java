package org.docksidestage.bizfw.basic.objanimal;

import org.docksidestage.bizfw.basic.objanimal.fly.Flyable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hakiba
 */
public class Bird extends Animal implements Flyable {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Logger logger = LoggerFactory.getLogger(Cat.class);

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======
    @Override
    protected String getBarkWord() {
        return "chirp";
    }

    // ===================================================================================
    //                                                                                 Fly
    //                                                                                 ===
    @Override
    public void fly() {
        logger.debug("...Flying now");
    }
}
