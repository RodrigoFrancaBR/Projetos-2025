package br.com.franca.bankaccount.outpoint.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "bank_account")
public class BankAccountModel {

    @Id
    @Column("id")
    private UUID id;
    @Column("accountNumber")
    private String accountNumber;
    @Column("accountType")
    private String accountType;
    @Column("balance")
    private BigDecimal balance;
    @Column("dailyWithdrawalLimit")
    private BigDecimal dailyWithdrawalLimit;
    @Column("accountHolderId")
    private UUID accountHolderId;

    // ver se coloca os ids das transações

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public void setDailyWithdrawalLimit(BigDecimal dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = dailyWithdrawalLimit;
    }

    public UUID getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(UUID accountHolderId) {
        this.accountHolderId = accountHolderId;
    }
}
