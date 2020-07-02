package br.com.hamburgueria.service;

import br.com.hamburgueria.domain.Lanche;
import br.com.hamburgueria.dto.LancheDto;
import br.com.hamburgueria.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public List<Lanche> listarLanchesDisponiveis(){
        List<Lanche> lanche = lancheRepository.findAll();
        for (int i = 0; i < lanche.size(); i++ ) {
            Lanche l = lanche.get(i);
            if (l.getDisponibilidadeLanche().equals(Boolean.FALSE)) {
                lanche.remove(i);
            }
        }
        return lanche;
    }

    public void salvarLanche(Lanche lanche){
        lancheRepository.save(lanche);
    }

    public void deletarLanche(Long id){
        lancheRepository.deleteById(id);
    }

    public Optional<Lanche> procurarLanche(Long id){
        return lancheRepository.findById(id);
    }

    public List<Lanche> listarTodosLanches(){
        List<Lanche> lanches = lancheRepository.findAll();
        return lanches;
    }

    public Lanche getOne(Long id) {
        return lancheRepository.getOne(id);
    }
}
