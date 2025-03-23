package br.com.franca.bankaccount.core.domain.validator;

import java.math.BigDecimal;
import java.util.Objects;

public class ValidatorUtil {

    private static ValidatorUtil instance;

    private ValidatorUtil() {
    }

    public static ValidatorUtil getInstance() {
        if (instance == null) {
            instance = new ValidatorUtil();
        }
        return instance;
    }

    public void validateNullFields(Object... values) {
        for (Object valor : values) {
            Objects.requireNonNull(valor, "value must not be null");
        }
    }

    public void isNull(BigDecimal value) {

    }

    public EComparisons compareToZero(final BigDecimal value) {
        Objects.requireNonNull(value, "value must not be null");
        int number = value.compareTo(BigDecimal.ZERO);
        // return EComparisons.getComparison(number);
        return null;
    }
}
