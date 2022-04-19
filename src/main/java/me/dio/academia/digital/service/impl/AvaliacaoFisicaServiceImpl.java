package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Aluno aluno = alunoRepository.getById(form.getAlunoId());
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());        
        avaliacaoFisica.setAluno(aluno);
        return avaliacaoRepository.save(avaliacaoFisica);            
    }

    @Override
    public AvaliacaoFisica get(Long id) {        
        return avaliacaoRepository.getById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {        
        return avaliacaoRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacao = avaliacaoRepository.getById(id);
        avaliacao.setAltura(formUpdate.getAltura());
        avaliacao.setPeso(formUpdate.getPeso());        
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public void delete(Long id) {
        AvaliacaoFisica avaliacao = avaliacaoRepository.getById(id);
        avaliacaoRepository.delete(avaliacao);
    }
}
