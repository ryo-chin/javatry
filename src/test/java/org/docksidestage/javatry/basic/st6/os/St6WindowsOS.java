package org.docksidestage.javatry.basic.st6.os;

/**
 * @author hakiba
 */
public class St6WindowsOS extends St6OperationSystem {
    public St6WindowsOS(String loginId) {
        super("Windows", loginId);
    }

    @Override
    protected String getFileSeparator() {
        return "\\";
    }

    @Override
    protected String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
