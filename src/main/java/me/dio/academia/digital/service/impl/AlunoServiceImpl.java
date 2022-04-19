package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService
{
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setBairro(form.getBairro());
        aluno.setCpf(form.getCpf());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return alunoRepository.getById(id);
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.getById(id);
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());        
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(aluno);        
    }

    @Override
    public void delete(Long id) {
        Aluno aluno = alunoRepository.getById(id);
        alunoRepository.delete(aluno);        
    }

    public List<Aluno> getAll ( String dataNascimento){
        return alunoRepository.findByDataDeNascimento(JavaTimeUtils.StringToDateTime(dataNascimento));
    }  

    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId( Long id ){
        return null;
    }
    
}
