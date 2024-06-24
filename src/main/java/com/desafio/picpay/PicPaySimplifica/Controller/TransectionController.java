package com.desafio.picpay.PicPaySimplifica.Controller;

import com.desafio.picpay.PicPaySimplifica.Dtos.TransectionsDto;
import com.desafio.picpay.PicPaySimplifica.Entity.Transections.Transections;
import com.desafio.picpay.PicPaySimplifica.Service.TransectionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transections")
public class TransectionController {

    @Autowired
    private TransectionsService transectionsService;


    @PostMapping
    public ResponseEntity<Transections> createTransections(@Valid @RequestBody TransectionsDto transectionsDto) throws Exception {
        Transections newTransection = this.transectionsService.sender(transectionsDto);
        return new ResponseEntity<>(newTransection, HttpStatus.OK);
    }

}