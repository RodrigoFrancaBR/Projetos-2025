package br.com.franca.bankaccount.core.domain.entity;

import br.com.franca.bankaccount.core.domain.entity.bankaccount.BankAccount;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@DisplayName("Bank Account tests")
class BankAccountTest {

    /**
     * Open bank account
     */

    @Nested
    @DisplayName("Given bank account with null id")
    class BankAccountWithNullId {

        private BankAccount bankAccountWithAllNull;

        @BeforeEach
        void beforeEach() {
            bankAccountWithAllNull = new BankAccount(null,
                    null,
                    (String) null,
                    null,
                    null,
                    null,
                    null);
        }

        private BankAccount getBankAccount() {
            return this.bankAccountWithAllNull;
        }

        @Nested
        @DisplayName("When open bank account")
        class OpenBankAccount {

            private BankAccount openBankAccount;

            @Test
            @DisplayName("Then should not throw exception")
            void shouldNotThrowException() {
                Assertions.assertDoesNotThrow(() -> {
                    openBankAccount = getBankAccount();
                });
            }

            @Test
            @DisplayName("Then must have a valid id")
            void mustHaveValidBankAccount_id() {
                Assertions.assertDoesNotThrow(() -> {
                    openBankAccount = getBankAccount();
                });
                Assertions.assertNotNull(openBankAccount.id());
            }
        }
    }

    @Nested
    @DisplayName("Given bank account with all fields null")
    class BankAccountWithAllFieldsNull {

        private BankAccount bankAccountWithAllNull;

        @BeforeEach
        void beforeEach() {
            bankAccountWithAllNull = new BankAccount(null,
                    null,
                    (String) null,
                    null,
                    null,
                    null,
                    null);
        }

        private BankAccount getBankAccount() {
            return this.bankAccountWithAllNull;
        }

        @Nested
        @DisplayName("When open bank account")
        class OpenBankAccount {

            private BankAccount openBankAccount;

            @Test
            @DisplayName("Then should not throw exception")
            void shouldNotThrowException() {
                Assertions.assertDoesNotThrow(() -> {
                    openBankAccount = getBankAccount();
                });
            }

            @Test
            @DisplayName("Then must have all fields valid")
            void mustHaveValidAllFields() {
                Assertions.assertDoesNotThrow(() -> {
                    openBankAccount = getBankAccount();
                });
                Assertions.assertAll("Bank account Assertions",
                        () -> Assertions.assertNotNull(openBankAccount.id()),
                        () -> Assertions.assertNotNull(openBankAccount.accountNumber()),
                        () -> Assertions.assertNotNull(openBankAccount.accountType()),
                        () -> Assertions.assertNotNull(openBankAccount.balance()),
                        () -> Assertions.assertNotNull(openBankAccount.dailyWithdrawalLimit()),
                        () -> Assertions.assertNotNull(openBankAccount.accountHolderId()),
                        () -> Assertions.assertNotNull(openBankAccount.transactions())
                );
            }
        }
    }

    /**
     * Bank account withdrawal
     */

    @Nested
    @DisplayName("Given withdrawal amount equals null")
    class WithdrawalAmountEqualsNull {

        private BankAccount withdrawalAmountEqualsNull;

        @BeforeEach
        void beforeEach() {
            withdrawalAmountEqualsNull = new BankAccount(null,
                    null,
                    (String) null,
                    null,
                    null,
                    null,
                    null);
        }

        @Nested
        @DisplayName("When withdrawal")
        class WithdrawalAmountEqualsNullWhenWithdrawal {

            @DisplayName("Then should throw exception")
            @Test
            void shouldThrowException() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> withdrawalAmountEqualsNull.withdrawal(null),
                        "Should throw IllegalArgumentException");
            }
        }
    }

    @Nested
    @DisplayName("Given withdrawal amount equals zero")
    class WithdrawalAmountEqualsZero {

        private BankAccount withdrawalAmountEqualsZero;

        @BeforeEach
        void beforeEach() {
            withdrawalAmountEqualsZero = new BankAccount(null,
                    null,
                    (String) null,
                    null,
                    null,
                    null,
                    null);
        }

        @Nested
        @DisplayName("When withdrawal")
        class WithdrawalAmountEqualsZeroWhenWithdrawal {

            @DisplayName("Then should throw exception")
            @Test
            void shouldThrowException() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> withdrawalAmountEqualsZero.withdrawal(BigDecimal.ZERO),
                        "Should throw IllegalArgumentException");
            }
        }
    }

    @Nested
    @DisplayName("Given withdrawal amount less than zero")
    class WithdrawalAmountLessThanZero {

        private BankAccount withdrawalAmountLessThanZero;

        @BeforeEach
        void beforeEach() {
            withdrawalAmountLessThanZero = new BankAccount(null,
                    null,
                    (String) null,
                    null,
                    null,
                    null,
                    null);
        }

        @Nested
        @DisplayName("When withdrawal")
        class WithdrawalAmountLessThanZeroWhenWithdrawal {

            @DisplayName("Then should throw exception")
            @Test
            void shouldThrowException() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> withdrawalAmountLessThanZero.withdrawal(new BigDecimal(-1)),
                        "Should throw IllegalArgumentException");
            }
        }
    }

    @Nested
    @DisplayName("Given withdrawal amount greater than balance")
    class WithdrawalAmountGreaterThanBalance {

        private BankAccount withdrawalAmountGreaterThanBalance;

        @BeforeEach
        void beforeEach() {
            withdrawalAmountGreaterThanBalance = new BankAccount(null,
                    null,
                    (String) null,
                    BigDecimal.ZERO,
                    null,
                    null,
                    null);
        }

        @Nested
        @DisplayName("When withdrawal")
        class WithdrawalAmountGreaterThanBalanceWhenWithdrawal {

            @DisplayName("Then should throw exception")
            @Test
            void shouldThrowException() {
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> withdrawalAmountGreaterThanBalance.withdrawal(BigDecimal.ONE),
                        "Should throw IllegalArgumentException");
            }
        }
    }

    @Nested
    @DisplayName("Given withdrawal amount equals than balance")
    class WithdrawalAmountEqualsThanBalance {

        private BankAccount withdrawalAmountEqualsThanBalance;
        private BankAccount bankAccountWithZeroBalance;

        @BeforeEach
        void beforeEach() {
            withdrawalAmountEqualsThanBalance = new BankAccount(null,
                    null,
                    (String) null,
                    BigDecimal.ONE,
                    null,
                    null,
                    null);
        }

        @Nested
        @DisplayName("When withdrawal")
        class WithdrawalAmountEqualsThanBalanceWhenWithdrawal {

            @DisplayName("Then should not throw exception")
            @Test
            void shouldNotThrowException() {
                bankAccountWithZeroBalance = Assertions.assertDoesNotThrow(
                        () -> withdrawalAmountEqualsThanBalance.withdrawal(BigDecimal.ONE),
                        "Should not throw any exception");
            }

            @DisplayName("Then should balance equals zero")
            @Test
            void shouldBalanceEqualsZero() {
                Assertions.assertEquals(BigDecimal.ZERO, bankAccountWithZeroBalance.balance());
            }
        }
    }

}
