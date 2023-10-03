package br.mic.financiamento_coletivo.service;

import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.repository.RifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RifaService {
    private final RifaRepository rifaRepository;

    @Autowired
    public RifaService(RifaRepository rifaRepository) {
        this.rifaRepository = rifaRepository;
    }
    // Resto do código do serviço
    public void salvarRifa(Rifa novaRifa)
    {
        // Chama o método save do repositório para salvar a rifa no banco de dados
        rifaRepository.save(novaRifa);
    }

    public List<Rifa> listarTodasAsRifas() {
        return rifaRepository.findAll();
    }
}
