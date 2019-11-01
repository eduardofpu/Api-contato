package com.org.Service;

import com.org.modelo.Contato;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContatoService {
    List<Contato> findAll(Pageable pageable);
    Contato create(Contato contato);
    void delete(Long id);
    Contato Update(Long id, Contato contato);
}
