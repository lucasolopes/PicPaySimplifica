package com.desafio.picpay.PicPaySimplifica.Service;

import com.desafio.picpay.PicPaySimplifica.Dtos.TransectionsDto;
import com.desafio.picpay.PicPaySimplifica.Entity.Transections.Transections;
import com.desafio.picpay.PicPaySimplifica.Entity.User.User;
import com.desafio.picpay.PicPaySimplifica.Repository.TransectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
public class TransectionsService {

    @Autowired
    private TransectionsRepository transectionsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificacaoService notificacaoService;

    public Transections sender(TransectionsDto transection) throws Exception {
        User sender = this.userService.findById(transection.getSenderId());
        User reciver = this.userService.findById(transection.getReceiverId());

        userService.validatedTransection(sender, transection.getValue());

        if (!(this.authorizeTransaction(sender, transection.getValue()))) {
            throw new Exception("Transacao nao autorizada");
        }

        Transections newTransection = new Transections();
        newTransection.setAmount(transection.getValue());
        newTransection.setSender(sender);
        newTransection.setReciver(reciver);
        newTransection.setTimeStamp(LocalDateTime.now());

        sender.setSaldo(sender.getSaldo().subtract(transection.getValue()));
        reciver.setSaldo(reciver.getSaldo().add(transection.getValue()));

        this.transectionsRepository.save(newTransection);
        this.userService.saveUser(sender);
        this.userService.saveUser(reciver);

        //this.notificacaoService.sendNotificacao(sender, "transacao realizada com sucesso!");

        //this.notificacaoService.sendNotificacao(reciver, "transacao recebida com sucesso!");

        return newTransection;
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
       /* ResponseEntity<Map> autorizeResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
        if (autorizeResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) autorizeResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;*/
        return true;
    }


}