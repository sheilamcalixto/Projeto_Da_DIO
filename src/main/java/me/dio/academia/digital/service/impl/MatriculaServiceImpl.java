package me.dio.academia.digital.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Aluno aluno = alunoRepository.getById(form.getAlunoId());
        Matricula matricula = new Matricula();
        matricula.setDataDaMatricula(LocalDateTime.now());
        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {        
        return matriculaRepository.getById(id);
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Matricula matricula = matriculaRepository.getById(id);
        matriculaRepository.delete(matricula);
        
    }   
    
    public List<Matricula> findAlunosMatriculadosBairro(String bairro){
        return matriculaRepository.findAlunosMatriculadosBairro(bairro);
    }
}
