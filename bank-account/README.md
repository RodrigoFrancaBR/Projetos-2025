🎯 Iniciativa: Sistema Bancário Digital
🏦 Objetivo:
Desenvolver um sistema bancário digital para permitir que correntistas gerenciem suas contas, realizem transações financeiras, recebam notificações e acessem serviços como empréstimos e investimentos.

⛏️ Projeto: Conta Bancária em Java

📌 Funcionalidades Essenciais
Transferência entre contas → Permitir transferir dinheiro entre contas bancárias.

Extrato bancário → Registrar e exibir um histórico das transações (saques, depósitos, transferências).

Juros e rendimentos → Implementar um método para calcular juros para contas poupança ou investimentos.

Limite de saque → Definir um limite diário ou por transação para saques.

Criação de Conta com Tipos Diferentes → Criar diferentes tipos de conta, como Conta Corrente e Conta Poupança.

💳 Funcionalidades Avançadas

Pagamento de contas e boletos → Criar um método para pagar contas direto da conta bancária.

Débito automático → Permitir configurar pagamentos recorrentes, como assinaturas ou contas mensais.

Notificações → Enviar alertas para movimentações (por e-mail ou console).

Empréstimo e crédito → Permitir solicitar crédito e calcular juros e parcelas.

Bloqueio da conta → Implementar um bloqueio para evitar movimentações em casos de fraude.

✨ Funcionalidades Implementadas

Depósito

Saque

Consulta de Saldo

⚙ Tecnologias Utilizadas

Java 17+

Spring Boot

Maven

🔧 Como Executar o Projeto

1. Clonar o repositório:

git clone git clone https://github.com/RodrigoFrancaBR/Projetos-2025.git
cd conta-bancaria

2. Compilar e executar

Se estiver usando Maven, rode:

mvn spring-boot:run

Ou, caso esteja usando um IDE como IntelliJ ou VS Code, basta rodar a classe principal.

💡 Exemplo de Uso
Aqui está um exemplo de como usar a classe ContaBancaria:
ContaBancaria conta = new ContaBancaria(100);
conta.depositar(50);
conta.sacar(30);
System.out.println("Saldo atual: " + conta.getSaldo());

📚 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usar e modificar!

**Desenvolvido por **Rodrigo França ✨
