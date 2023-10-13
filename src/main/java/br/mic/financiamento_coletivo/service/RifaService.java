package br.mic.financiamento_coletivo.service;

import br.mic.financiamento_coletivo.model.Jogo;
import br.mic.financiamento_coletivo.model.Rifa;
import br.mic.financiamento_coletivo.repository.JogoRepository;
import br.mic.financiamento_coletivo.repository.RifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RifaService
{
    private final RifaRepository rifaRepository;

    @Autowired
    public RifaService(RifaRepository rifaRepository)
    {
        this.rifaRepository = rifaRepository;
    }

    @Autowired
    private JogoRepository jogoRepository; // Suponha que você tenha um repositório JPA para Jogos


    // Resto do código do serviço
    public void salvarRifa(Rifa novaRifa)
    {
        // Chama o método save do repositório para salvar a rifa no banco de dados
        rifaRepository.save(novaRifa);
    }

    public List<Rifa> listarTodasAsRifas()
    {
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

    public List<String> obterCodigosRifa()
    {
        List<Rifa> rifas = rifaRepository.findAll();
        return rifas.stream().map(rifa -> String.valueOf(rifa.getId_rifa())).collect(Collectors.toList());
    }

    public Rifa obterRifaPorId(Integer id)
    {
        return rifaRepository.findById(id).orElse(null);
    }

    public List<Integer> obterNumerosSelecionados(int idRifa)
    {
        // Suponha que você tenha uma entidade Rifa que tem uma relação com os números selecionados
        // e você queira obter uma lista de números selecionados com base no ID da rifa.

        // Substitua "Rifa" pelo nome da sua entidade de rifa e "numerosSelecionados" pelo nome do relacionamento.
        Rifa rifa = rifaRepository.findById(idRifa).orElse(null);

        if (rifa != null)
        {
            // Acesse a lista de números selecionados na entidade Rifa e retorne-a.
            List<Jogo> jogo = jogoRepository.findByRifa(rifa);

            // Crie uma lista para armazenar os números selecionados.
            List<Integer> numerosSelecionados = new ArrayList<>();

            for (Jogo jogos : jogo) {
                numerosSelecionados.add(Integer.parseInt(jogos.getNumero_escolhido()));
            }

            return numerosSelecionados;
        } else
        {
            // Caso a rifa com o ID especificado não seja encontrada, retorne uma lista vazia ou null, dependendo do seu caso.
            return new ArrayList<>(); // Ou return null;
        }
    }
}
