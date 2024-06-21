package com.desafio.picpay.PicPaySimplifica.Repository;

import com.desafio.picpay.PicPaySimplifica.Entity.Transections.Transections;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransectionsRepository extends JpaRepository<Transections, Long> {
}
