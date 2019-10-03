package org.docksidestage.javatry.basic.st6.os;

/**
 * @author hakiba
 */
public class St6OldWindowsOS extends St6OperationSystem {
    public St6OldWindowsOS(String loginId) {
        super("OldWindows", loginId);
    }

    @Override
    protected String getFileSeparator() {
        return "\\";
    }

    @Override
    protected String getUserDirectory() {
        return "/Documents and Settigs/" + loginId;
    }
}
