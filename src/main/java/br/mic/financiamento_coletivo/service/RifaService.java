package br.mic.financiamento_coletivo.service;

import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.repository.RifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void excluirRifa(Integer id)
    {
        // Use o repositório para encontrar a rifa pelo ID
        Optional<Rifa> rifaOptional = rifaRepository.findById(id);

        // Verifique se a rifa existe antes de tentar excluí-la
        if (rifaOptional.isPresent())
        {
            Rifa rifa = rifaOptional.get();
            rifaRepository.delete(rifa);
        }
    }

    public List<String> obterCodigosRifa() {
        List<Rifa> rifas = rifaRepository.findAll();
        return rifas.stream()
                .map(rifa -> String.valueOf(rifa.getId_rifa()))
                .collect(Collectors.toList());
    }

    public Rifa obterRifaPorId(Integer id) {
        return rifaRepository.findById(id).orElse(null);
    }

}
