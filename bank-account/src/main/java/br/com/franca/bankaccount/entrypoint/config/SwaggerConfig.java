package br.com.franca.bankaccount.entrypoint.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Conta Bancária")
                        .version("1.0")
                        .description("API para gerenciamento de contas bancárias, incluindo saldo, depósitos, saques e transferências.")
                        .contact(new Contact()
                                .name("Suporte API")
                                .email("suporte@banco.com")
                                .url("https://banco.com")));
    }
}
