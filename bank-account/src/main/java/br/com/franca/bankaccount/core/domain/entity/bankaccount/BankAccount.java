package br.com.franca.bankaccount.core.domain.entity.bankaccount;

import br.com.franca.bankaccount.core.domain.util.ValueGenerator;
import br.com.franca.bankaccount.core.domain.validator.EComparisons;

import java.math.BigDecimal;
import java.util.*;

public record BankAccount(
        BankAccountId id,
        String accountNumber,
        AccountType accountType,
        BigDecimal balance,
        BigDecimal dailyWithdrawalLimit,
        AccountHolderId accountHolderId,
        List<TransactionId> transactions
) {

//    public BankAccount(
//            BankAccountId id,
//            String accountNumber,
//            AccountType accountType,
//            BigDecimal balance,
//            BigDecimal dailyWithdrawalLimit,
//            AccountHolderId accountHolderId,
//            List<TransactionId> transactions
//    ) {
//        throw new UnsupportedOperationException("Use constructor with String for accountType");
//    }

    public BankAccount(
            BankAccountId id,
            String accountNumber,
            String accountType,
            BigDecimal balance,
            BigDecimal dailyWithdrawalLimit,
            AccountHolderId accountHolderId,
            List<TransactionId> transactions
    ) {
        this(getDefaultBankAccountId(id), getDefaultAccountNumber(accountNumber),
                getDefaultAccountType(accountType), getDefaultValue(balance),
                getDefaultValue(dailyWithdrawalLimit), getDefaultAccountHolderId(accountHolderId),
                getDefaultTransactions(transactions));
    }

    public BankAccount(
            AccountHolderId accountHolderId) {
        this(null, null, (String) null, null, null, accountHolderId, null);
    }

    public BankAccount withdrawal(final BigDecimal amount) {
        final var empty = Optional.ofNullable(amount)
                .filter(this::filterAmountWhenNotZeroOrLessThanZero)
                .filter(this::filterAmountWhenSufficientBalance)
                .isEmpty();
        if (empty) {
            throw new IllegalArgumentException("amount is invalid: Amount should be not null, should be not zero or less then zero and has sufficient balance");
        }
        var balance = this.balance.subtract(amount);
        return new BankAccount(
                id,
                accountNumber,
                accountType, // Corrente ou Poupança
                balance,
                dailyWithdrawalLimit,
                accountHolderId,
                transactions
        );
    }

    public BankAccount deposit(final BigDecimal amount) {
        var validAmount = Optional.ofNullable(amount)
                .map(this::getAmountWhenIsNotZeroOrLessElseThrow)
                .orElseThrow(() -> new IllegalArgumentException("amount must not be null"));
        // throwExceptionWhenAmountIsNull(amount);
        // throwExceptionWhenAmountIsZeroOrLess(amount);
        var balance = this.balance.add(validAmount);
        return new BankAccount(
                id,
                accountNumber,
                accountType, // Corrente ou Poupança
                balance,
                dailyWithdrawalLimit,
                accountHolderId,
                transactions
        );
    }


    private static List<TransactionId> getDefaultTransactions(List<TransactionId> transactions) {
        return transactions == null ? Collections.emptyList() : transactions;
    }

    private static AccountHolderId getDefaultAccountHolderId(AccountHolderId accountHolderId) {
        return accountHolderId == null ? new AccountHolderId() : accountHolderId;
    }

    private static BigDecimal getDefaultValue(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }

    private static AccountType getDefaultAccountType(String accountType) {
        return Arrays.stream(AccountType.values())
                .filter(type -> type.name().equalsIgnoreCase(accountType))
                .findFirst()
                .orElse(AccountType.UNDEFINED);
    }

    private static String getDefaultAccountNumber(String accountNumber) {
        return accountNumber == null ? ValueGenerator.getInstance().getNumber(5, 1, 9) : accountNumber;
    }

    private static BankAccountId getDefaultBankAccountId(BankAccountId id) {
        return id == null ? new BankAccountId() : id;
    }

    private BigDecimal getAmountWhenIsNotNullElseThrow(BigDecimal amount) {
        return Optional.ofNullable(amount).orElseThrow(() -> new IllegalArgumentException("amount must not be null"));
    }

    private boolean filterAmountWhenSufficientBalance(BigDecimal amount) {
        final var number = EComparisons.compareValueToOtherValue(balance, amount);
        return !number.isLessThanZero();
//        if (number.isLessThanZero()) {
//            throw new RuntimeException("Insufficient Balance");
//        }
//        return amount;
    }

    private BigDecimal getAmountWhenSufficientBalanceElseThrow(BigDecimal amount) {
        final var number = EComparisons.compareValueToOtherValue(balance, amount);
        if (number.isLessThanZero()) {
            throw new RuntimeException("Insufficient Balance");
        }
        return amount;
    }

    private boolean filterAmountWhenNotZeroOrLessThanZero(BigDecimal amount) {
        final var number = EComparisons.compareValueToZero(amount);
        return !number.isEqualToZero() && !number.isLessThanZero();
//        if (number.isLessThanZero() || number.isEqualToZero()) {
//            // throw new IllegalArgumentException("The deposit amount cannot be zero or less.");
//            return false;
//        }
//        return true;
    }

    private BigDecimal getAmountWhenIsNotZeroOrLessElseThrow(BigDecimal amount) {
        final var number = EComparisons.compareValueToZero(amount);
        if (number.isLessThanZero() || number.isEqualToZero()) {
            throw new IllegalArgumentException("The deposit amount cannot be zero or less.");
        }
        return amount;
    }

    public BigDecimal balance() {
        return this.balance;
    }

    private void throwExceptionWhenAmountIsNull(final BigDecimal amount) {
        Objects.requireNonNull(amount, "amount must not be null");
    }

    private void throwExceptionWhenAmountIsZeroOrLess(final BigDecimal amount) {
        final var number = EComparisons.compareValueToZero(amount);
        if (number.isLessThanZero() || number.isEqualToZero()) {
            throw new IllegalArgumentException("The deposit amount cannot be zero or less.");
        }
    }

    private void throwExceptionWhenInsufficientBalance(final BigDecimal amount) {
        final var number = EComparisons.compareValueToOtherValue(balance, amount);
        if (number.isLessThanZero()) {
            throw new RuntimeException("Insufficient Balance");
        }
    }
}
