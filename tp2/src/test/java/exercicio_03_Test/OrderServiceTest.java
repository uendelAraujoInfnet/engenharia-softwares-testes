package exercicio_03_Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.uendel.exercicio_03.OrderService;
import com.uendel.exercicio_03.PaymentProcessor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
  private PaymentProcessor paymentProcessorMock;
  private OrderService orderService;

  @BeforeEach
  void setUp(){
    // Criando um mock da interface PaymantProcessor
    paymentProcessorMock = mock(PaymentProcessor.class);

    //Injeção do mock no OrderService
    orderService = new OrderService(paymentProcessorMock);
  }

  @Test
  void testProcessOrder_PaymentApproved(){
    //Configura o mock para defenir um retorno true quando for chamadoi
    when(paymentProcessorMock.processPayment(100.0)).thenReturn(true);

    //Faz o método ser executado sob teste
    boolean result = orderService.processOrder(100.0);

    //Verifica a procedencia do resultado
    assertTrue(result, "O pedido deveria ser confirmado");

    //Verifica o método processPayment para saber se o valor indicado está correto
    verify(paymentProcessorMock, times(1)).processPayment(100.0);
  }

  @Test
    void testProcessOrder_PaymentDeclined() {
        //Configura o mock para retornar false quando chamado
        when(paymentProcessorMock.processPayment(200.0)).thenReturn(false);

        //Executa o método sob teste
        boolean result = orderService.processOrder(200.0);

        //Verifica se o resultado está correto
        assertFalse(result, "O pedido deveria ser recusado.");

        //Verifica se o método processPayment foi chamado com o valor correto
        verify(paymentProcessorMock, times(1)).processPayment(200.0);
    }
}
