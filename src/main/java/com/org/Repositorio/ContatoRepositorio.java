package com.org.Repositorio;

import com.org.modelo.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContatoRepositorio extends JpaRepository<Contato, Long> {

    Contato findByAndId(Long id);

    @Query(value = "select c from Contato c order by c.id")
    List<Contato> getContatoOrderBy();
}
