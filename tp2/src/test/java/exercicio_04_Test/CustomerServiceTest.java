package exercicio_04_Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uendel.exercicio_04.Customer;
import com.uendel.exercicio_04.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {
  private CustomerService customerService;

  @BeforeEach
  void setUp() {
      customerService = new CustomerService();
  }

  // Teste de Cadastro com Idade Válida e Inválida (Análise de Valor Limite)
  @Test
  void testRegisterCustomer_ValidAge() {
      Customer validCustomer = new Customer(1, "John Doe", "john@example.com", 18, true);
      assertTrue(customerService.registerCustomer(validCustomer), "Cliente com idade 18 deveria ser cadastrado");

      validCustomer = new Customer(2, "Jane Doe", "jane@example.com", 99, true);
      assertTrue(customerService.registerCustomer(validCustomer), "Cliente com idade 99 deveria ser cadastrado");
  }

  @Test
  void testRegisterCustomer_InvalidAge() {
      Customer tooYoung = new Customer(3, "Too Young", "young@example.com", 17, true);
      assertFalse(customerService.registerCustomer(tooYoung), "Cliente com idade 17 não deveria ser cadastrado");

      Customer tooOld = new Customer(4, "Too Old", "old@example.com", 100, true);
      assertFalse(customerService.registerCustomer(tooOld), "Cliente com idade 100 não deveria ser cadastrado");
  }

  // Teste de Atualização de Cliente Ativo e Inativo
  @Test
  void testUpdateCustomer_ActiveCustomer() {
      Customer activeCustomer = new Customer(5, "Active User", "active@example.com", 30, true);
      assertTrue(customerService.updateCustomer(activeCustomer, "Updated Name", "updated@example.com", 35),
              "Cliente ativo deveria ser atualizado");
  }

  @Test
  void testUpdateCustomer_InactiveCustomer() {
      Customer inactiveCustomer = new Customer(6, "Inactive User", "inactive@example.com", 30, false);
      assertFalse(customerService.updateCustomer(inactiveCustomer, "Updated Name", "updated@example.com", 35),
              "Cliente inativo não deveria ser atualizado");
  }

  // Teste de Exclusão de Cliente Ativo e Inativo
  @Test
  void testDeleteCustomer_ActiveCustomer() {
      Customer activeCustomer = new Customer(7, "Active User", "active@example.com", 40, true);
      assertTrue(customerService.deleteCustomer(activeCustomer), "Cliente ativo deveria ser excluído");
  }

  @Test
  void testDeleteCustomer_InactiveCustomer() {
      Customer inactiveCustomer = new Customer(8, "Inactive User", "inactive@example.com", 40, false);
      assertFalse(customerService.deleteCustomer(inactiveCustomer), "Cliente inativo não deveria ser excluído");
  }

  // Teste de Validação de E-mail (Partição de Equivalência)
  @Test
  void testRegisterCustomer_ValidEmail() {
      Customer validEmailCustomer = new Customer(9, "Valid Email", "valid@example.com", 25, true);
      assertTrue(customerService.registerCustomer(validEmailCustomer), "Cliente com e-mail válido deveria ser cadastrado");
  }

  @Test
  void testRegisterCustomer_InvalidEmail_NoAtSymbol() {
      Customer invalidEmail = new Customer(10, "Invalid Email", "invalidexample.com", 25, true);
      assertFalse(customerService.registerCustomer(invalidEmail), "Cliente com e-mail sem @ não deveria ser cadastrado");
  }

  @Test
  void testRegisterCustomer_InvalidEmail_NoDomain() {
      Customer invalidEmail = new Customer(11, "Invalid Email", "invalid@", 25, true);
      assertFalse(customerService.registerCustomer(invalidEmail), "Cliente com e-mail sem domínio não deveria ser cadastrado");
  }

  // Teste de Cadastro Completo
  @Test
  void testRegisterCustomer_ValidData() {
      Customer validCustomer = new Customer(12, "John Doe", "john.doe@example.com", 30, true);
      assertTrue(customerService.registerCustomer(validCustomer), "Cliente válido deveria ser cadastrado");
  }
}
