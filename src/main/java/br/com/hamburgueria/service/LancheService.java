package br.com.hamburgueria.service;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public List<Lanche> listarLanches(){
        List<Lanche> lanches = lancheRepository.findAll();
        return lanches;
    }

}
