package br.com.franca.bankaccount.core.domain.entity;

import br.com.franca.bankaccount.core.domain.validator.ValidatorUtil;

import java.math.BigDecimal;

public record BankAccount(
        Long id,
        BigDecimal balance,
        String titular,
        String document,
        String email,
        String telefone,
        BigDecimal rendaMensal,
        String endereco,
        String tipoConta
) {

    // regra de negócio para criar uma conta bancária todos os campos devem ser diferentes de null

    public BankAccount {
        ValidatorUtil.getInstance().validateNullFields(balance, titular, document, email, telefone, rendaMensal, endereco, tipoConta);
    }

    public BankAccount withdrawal(final BigDecimal amount) {
        throwExceptionWhenAmountZeroOrLess(amount);
        throwExceptionWhenInsufficientBalance(amount);
        var balance = this.balance.subtract(amount);
        return new BankAccount(id, balance, titular, document, email, telefone, rendaMensal, endereco, tipoConta);
    }

    public BankAccount deposit(final BigDecimal amount) {
        throwExceptionWhenAmountZeroOrLess(amount);
        var balance = this.balance.add(amount);
        return new BankAccount(id, balance, titular, document, email, telefone, rendaMensal, endereco, tipoConta);

    }

    public BigDecimal balance() {
        return this.balance;
    }

    private void throwExceptionWhenAmountZeroOrLess(final BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The deposit amount cannot be zero or less.");
        }
    }

    private void throwExceptionWhenInsufficientBalance(final BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0)
            throw new RuntimeException("Insufficient Balance");
    }
}

//
//public class BankAccountDomain {
//    // aplicar o padrão builder
//
//    private Long id;
//    private BigDecimal balance;
//    private String titular;
//    private String document;
//    private String email;
//    private String telefone;
//    private BigDecimal rendaMensal;
//    private String endereco;
//    private String tipoConta;
//
////    @Deprecated(since = "Usado pelos mappers")
////    public BankAccountDomain() {
////    }
//
//    public BankAccountDomain(
//            // Long Id,
//            BigDecimal balance,
//            String titular,
//            String document,
//            String email,
//            String telefone,
//            BigDecimal rendaMensal,
//            String endereco,
//            String tipoConta) {
//        // aplicar validação para os outros campos com base no dto da api rest
//        //givenNullBalanceWhenCreateAccountThenThrowException(balance);
//        this.balance = balance;
//
//        this.titular = titular;
//        this.document = document;
//        this.email = email;
//        this.telefone = telefone;
//        this.rendaMensal = rendaMensal;
//        this.endereco = endereco;
//        this.tipoConta = tipoConta;
//    }
//
//    public void withdrawal(final BigDecimal amount) {
//        givenAmountWhenIsZeroOrLessThenThrowException(amount);
//        givenAmountWhenInsufficientBalanceThenThrowException(amount);
//        this.balance = this.balance.subtract(amount);
//    }
//
//    public void deposit(final BigDecimal amount) {
//        givenAmountWhenIsZeroOrLessThenThrowException(amount);
//        this.balance = this.balance.add(amount);
//    }
//
//    public BigDecimal balance() {
//        return this.balance;
//    }
//
//    private void givenNullBalanceWhenCreateAccountThenThrowException(final BigDecimal field) {
//        if (field == null) {
//            throw new IllegalArgumentException("Balance cannot be null");
//        }
//    }
//
//    private static void givenAmountWhenIsZeroOrLessThenThrowException(final BigDecimal amount) {
//        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("The deposit amount cannot be zero or less.");
//        }
//    }
//
//    private void givenAmountWhenInsufficientBalanceThenThrowException(final BigDecimal amount) {
//        if (this.balance.compareTo(amount) < 0)
//            throw new RuntimeException("Insufficient Balance");
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public String getTitular() {
//        return titular;
//    }
//
//    public void setTitular(String titular) {
//        this.titular = titular;
//    }
//
//    public String getDocument() {
//        return document;
//    }
//
//    public void setDocument(String document) {
//        this.document = document;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public BigDecimal getRendaMensal() {
//        return rendaMensal;
//    }
//
//    public void setRendaMensal(BigDecimal rendaMensal) {
//        this.rendaMensal = rendaMensal;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public String getTipoConta() {
//        return tipoConta;
//    }
//
//    public void setTipoConta(String tipoConta) {
//        this.tipoConta = tipoConta;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BankAccountDomain that = (BankAccountDomain) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id);
//    }
//}
