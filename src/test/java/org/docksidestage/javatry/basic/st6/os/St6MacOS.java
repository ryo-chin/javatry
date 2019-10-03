package org.docksidestage.javatry.basic.st6.os;

/**
 * @author hakiba
 */
public class St6MacOS extends St6OperationSystem {
    public St6MacOS(String loginId) {
        super("Mac", loginId);
    }

    @Override
    protected String getFileSeparator() {
        return "/";
    }

    @Override
    protected String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
