package com.org.controlador;

import com.org.Service.ContatoService;
import com.org.modelo.Contato;
import org.springframework.beans.factory.annotation.Autowired;
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
    List<Contato> findAll(){
        return  contatoService.finAll();
    }

    @PostMapping(path = "savecontato")
    @ResponseStatus(HttpStatus.OK)
    Contato create(@RequestBody Contato contato){
        return  contatoService.create(contato);
    }

    @DeleteMapping(path = "deletecontato")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@RequestBody Contato contato){
        Long id = contato.getId();
        contatoService.delete(id);

    }

    @PutMapping(path = "updatecontato/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Contato update(@PathVariable("id") Long id, @RequestBody Contato contato){
        return  contatoService.Update(id,contato);
    }

}
