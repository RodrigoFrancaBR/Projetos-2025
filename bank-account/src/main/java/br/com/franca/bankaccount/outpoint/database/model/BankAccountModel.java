package br.com.franca.bankaccount.outpoint.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(name = "bank_account")
public class BankAccountModel {

//    public BankAccountModel(Long id, BigDecimal balance, String titular, String document, String email, String telefone, BigDecimal rendaMensal, String endereco, String tipoConta) {
//        this.id = id;
//        this.balance = balance;
//        this.titular = titular;
//        this.document = document;
//        this.email = email;
//        this.telefone = telefone;
//        this.rendaMensal = rendaMensal;
//        this.endereco = endereco;
//        this.tipoConta = tipoConta;
//    }

    @Id
    @Column("id")
    private Long id;
    @Column("balance") // Nome da coluna exatamente como está no H2
    private BigDecimal balance;

    @Column("titular")
    private String titular;

    @Column("document")
    private String document;

    @Column("email")
    private String email;

    @Column("telefone")
    private String telefone;

    @Column("renda_mensal")
    private BigDecimal rendaMensal;

    @Column("endereco")
    private String endereco;

    @Column("tipo_conta")
    private String tipoConta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(BigDecimal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
