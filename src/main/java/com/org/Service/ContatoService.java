package com.org.Service;

import com.org.modelo.Contato;

import java.util.List;

public interface ContatoService {
    List<Contato> finAll();
    Contato create(Contato contato);
    void delete(Long id);
    Contato Update(Long id, Contato contato);
}
