package br.mic.financiamento_coletivo.controller;

import br.mic.financiamento_coletivo.model.Jogo;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Controller
public class PagamentoRifaController {

    @GetMapping("/pagamentoRifa")
    public String paginaPagamentoRifa() {
        return "pagamentoRifa";
    }

    @PostMapping("/process_payment")
    public String process_payment(Model model, HttpServletRequest request, @RequestParam("id_rifa") String idRifa, @RequestParam("numeros") String numeros) {
        try {
            // Configure a chave de acesso do MercadoPago (substitua pela sua chave real)
            MercadoPagoConfig.setAccessToken("APP_USR-5579030860678637-101022-182436c107f980c52a171e0f27fd930c-202843783");

            PaymentClient client = new PaymentClient();

            // Obtenha os dados do formulário
            String payerFirstName = request.getParameter("payerFirstName");
            String payerLastName = request.getParameter("payerLastName");
            String email = request.getParameter("email");

            // Crie a solicitação de pagamento usando os dados do formulário
            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .transactionAmount(new BigDecimal("100"))
                    .description("Título do produto")
                    .paymentMethodId("pix")
                    .dateOfExpiration(OffsetDateTime.of(2023, 10, 12, 10, 10, 10, 0, ZoneOffset.UTC))
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(email)
                                    .firstName(payerFirstName)
                                    .lastName(payerLastName)
                                    .identification(
                                            IdentificationRequest.builder().type("CPF").number("19119119100").build())
                                    .build())
                    .build();

            // Crie o pagamento
            Payment payment = client.create(paymentCreateRequest);

            // Obtenha a URL do Pix e o código QR
            String pixUrl = payment.getPointOfInteraction().getTransactionData().getQrCode();
            String qrCodeBase64 = payment.getPointOfInteraction().getTransactionData().getQrCodeBase64();

            // Agora você pode usar pixUrl e qrCodeBase64 para exibir o Pix ao cliente
            model.addAttribute("pixUrl", pixUrl);
            model.addAttribute("qrCodeBase64", qrCodeBase64);

            System.out.println(pixUrl);

            //Jogo jogo = new Jogo(pegar o id da rifa, numero_selecionado, nome,sobrenome,email,telefone);
            System.out.println("Pelape" + idRifa);

        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
            // Lide com o erro de API do MercadoPago, como registrar ou fornecer feedback ao usuário.
        } catch (MPException ex) {
            ex.printStackTrace();
            // Lide com outras exceções MPException, se necessário.
        }
        return "resultadoPagamento"; // Redirecione para uma página de resultado
    }
}
