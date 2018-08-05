package com.example.qq;

import org.litepal.crud.DataSupport;

public class AccountData extends DataSupport {
    private String accountId;
    private String accountPassword;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
