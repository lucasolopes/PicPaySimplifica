package com.desafio.picpay.PicPaySimplifica.Service;

import com.desafio.picpay.PicPaySimplifica.Dtos.NotificacaoDto;
import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotificacao(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificacaoDto notificacaoRequest = new NotificacaoDto(email, message);
        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificacaoRequest, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception("Servico de notificacao esta fora do ar");
        }
    }
}