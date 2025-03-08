<<<<<<< HEAD
package com.uendel.calculoimc;

import static org.mockito.Mockito.*;

import com.uendel.calculoimc.service.ImcService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class IMCServiceTest {

    @Test
    void testCalculoIMCComMock() {
        ImcService imcService = mock(ImcService.class);
        when(imcService.calcularIMC(80, 1.80)).thenReturn(24.69);

        double imc = imcService.calcularIMC(80, 1.80);
        assertThat(imc).isEqualTo(24.69);
    }
=======
package com.uendel.calculoimc;

import static org.mockito.Mockito.*;

import com.uendel.calculoimc.service.ImcService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class IMCServiceTest {

    @Test
    void testCalculoIMCComMock() {
        ImcService imcService = mock(ImcService.class);
        when(imcService.calcularIMC(80, 1.80)).thenReturn(24.69);

        double imc = imcService.calcularIMC(80, 1.80);
        assertThat(imc).isEqualTo(24.69);
    }
>>>>>>> 03890a7ac8c4a4af8de13252e4f83983cc736942
}