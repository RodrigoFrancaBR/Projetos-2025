package br.com.franca.bankaccount.core.domain.validator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public enum EComparisons {

    LESS_THAN_ZERO(-1), EQUAL_TO_ZERO(0), GREATER_THAN_ZERO(1);

    private final int result;

    EComparisons(int result) {
        this.result = result;
    }

    public static EComparisons compareValueToZero(final BigDecimal value) {
        Objects.requireNonNull(value, "value must not be null");
        int number = value.compareTo(BigDecimal.ZERO);
        return getComparison(number);
    }

    public static EComparisons compareValueToOtherValue(BigDecimal value, BigDecimal otherValue) {
        Objects.requireNonNull(value, "value must not be null");
        int number = value.compareTo(otherValue);
        return getComparison(number);
    }

    public boolean isLessThanZero() {
        return Objects.equals(EComparisons.LESS_THAN_ZERO.name(), this.name());
    }

    public boolean isEqualToZero() {
        return Objects.equals(EComparisons.EQUAL_TO_ZERO.name(), this.name());
    }

    public boolean isGreaterThanZero() {
        return Objects.equals(EComparisons.GREATER_THAN_ZERO.name(), this.name());
    }


    public int getResult() {
        return result;
    }

    private static EComparisons getComparison(int number) {
        return Arrays.stream(EComparisons.values()).filter(e -> Objects.equals(e.getResult(), number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The specified enum has no constant with the specified number " +
                        "or the specified number does not represent an enum class"));
    }
}
