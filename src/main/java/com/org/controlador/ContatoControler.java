package com.org.controlador;

import com.org.Service.ContatoService;
import com.org.modelo.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ContatoControler {

    private ContatoService contatoService;

    @Autowired
    public ContatoControler(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping(path = "buscarcontato")
    @ResponseStatus(HttpStatus.OK)
    List<Contato> findAll(Pageable pageable) {
        return  contatoService.findAll(pageable);
    }

    @PostMapping(path = "savecontato")
    @ResponseStatus(HttpStatus.OK)
    Contato create(@RequestBody Contato contato){
        return  contatoService.create(contato);
    }

    @DeleteMapping(path = "deletecontato/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id){
        contatoService.delete(id);

    }

    @PutMapping(path = "updatecontato/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Contato update(@PathVariable("id") Long id, @RequestBody Contato contato){
        return  contatoService.Update(id,contato);
    }

}
