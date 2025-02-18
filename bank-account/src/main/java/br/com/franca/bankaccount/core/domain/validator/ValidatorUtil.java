package br.com.franca.bankaccount.core.domain.validator;

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

    public void validateNullFields(Object... valores) {
        for (Object valor : valores) {
            Objects.requireNonNull(valor, "Campo obrigatório não pode ser nulo");
        }
    }
}
