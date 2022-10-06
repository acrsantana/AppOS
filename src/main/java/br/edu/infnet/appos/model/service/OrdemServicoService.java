package br.edu.infnet.appos.model.service;

import br.edu.infnet.appos.model.domain.OrdemServico;
import br.edu.infnet.appos.model.domain.Servico;
import br.edu.infnet.appos.model.dto.OrdemServicoDto;
import br.edu.infnet.appos.model.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired OrdemServicoRepository ordemServicoRepository;
    @Autowired VeiculoService veiculoService;
    @Autowired SolicitanteService solicitanteService;
    @Autowired ServicoService servicoService;

    public void addOrdemServico(OrdemServico ordemServico) {
        ordemServicoRepository.save(ordemServico);
    }
    public void addOrdemServico(OrdemServicoDto ordemServicoDto) {
        System.out.println(ordemServicoDto);
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setMecanico(ordemServicoDto.getMecanico());
        ordemServico.setGarantia(ordemServicoDto.isGarantia());
        ordemServico.setSolicitante(solicitanteService.findById(ordemServicoDto.getSolicitante()));
        ordemServico.setVeiculo(veiculoService.findById(ordemServicoDto.getVeiculo()));

        List<Servico> servicos = new ArrayList<>();
        ordemServicoDto.getServicos().forEach(srv -> {
            servicos.add(servicoService.findById(srv));
        });
        ordemServico.setServicos(servicos);
        ordemServico.setData(LocalDateTime.now());
        addOrdemServico(ordemServico);
    }
    public List<OrdemServico> getOrdemServico() {
        return ordemServicoRepository.findAll();
    }

    public void remove(Integer id) {
        ordemServicoRepository.deleteById(id);
    }
}
