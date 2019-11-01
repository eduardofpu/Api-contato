package com.org.Service.ServiceImpl;

import com.org.Repositorio.ContatoRepositorio;
import com.org.Service.ContatoService;
import com.org.modelo.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContatoServiceImpl implements ContatoService {
    private ContatoRepositorio contatoRepositorio;

    @Autowired
    public ContatoServiceImpl(ContatoRepositorio contatoRepositorio) {
        this.contatoRepositorio = contatoRepositorio;
    }

    @Override
    public List<Contato> findAll(Pageable pageable) {
        return contatoRepositorio.getContatoOrderBy(pageable);
    }

    @Override
    public Contato create(Contato contato) {
        return contatoRepositorio.save(contato);
    }

    @Override
    public void delete(Long id) {
        Contato codigo = contatoRepositorio.findByAndId(id);
        if(codigo.getId()!=null){
            contatoRepositorio.delete(codigo);
        }else {
            System.out.println("Erro ao realizar o Delete");
        }

    }

    @Override
    public Contato Update(Long id, Contato contato) {
        if(id==null){
            System.out.println("Erro ao realizar o Update");
        }
        contato.setId(id);
        return contatoRepositorio.save(contato);
    }
}
