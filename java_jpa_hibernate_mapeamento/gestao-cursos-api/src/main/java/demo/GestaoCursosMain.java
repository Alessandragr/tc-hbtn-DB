package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.sql.Date;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Aluno aluno = new Aluno();
        aluno.setEmail("aaaa@aaa.com");
        aluno.setMatricula("aaaaaa");
        aluno.setNascimento(new Date(1990/9/9));
        aluno.setNomeCompleto("Aaaaaaaa");


        Aluno aluno2 = new Aluno();
        aluno.setEmail("bbbb@bbb.com");
        aluno.setMatricula("bbbb");
        aluno.setNascimento(new Date(1998/8/8));
        aluno.setNomeCompleto("Bbbbbb");

        Curso curso = new Curso();
        curso.setMaterialCurso(new MaterialCurso("aaaa"));
        curso.setNome("Aaaaa");
        curso.setSigla("aaaa235");

        Curso curso2 = new Curso();
        curso2.setMaterialCurso(new MaterialCurso("bbbb"));
        curso2.setNome("Bbbbb");
        curso2.setSigla("bbbb235");


        // 1) Criando um produto e pessoa

        alunoModel.create(aluno);
        alunoModel.create(aluno2);
        cursoModel.create(curso);
        cursoModel.create(curso2);

        //2) Buscando todos os produtos e pessoas na base de dados
        List<Curso> cursos = cursoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + cursos.size());

        List<Aluno> alunos = alunoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + alunos.size());

        //3) Listar por id
        alunoModel.findById(aluno);
        cursoModel.findById(curso);

        //4) update
        aluno.setEmail("ccccc@ccc.com");
        aluno.setMatricula("cccc");
        aluno.setNascimento(new Date(1998/8/8));
        aluno.setNomeCompleto("CCCC");
        alunoModel.update(aluno);

        curso.setMaterialCurso(new MaterialCurso("bbbb"));
        curso.setNome("Bbbbb");
        curso.setSigla("bbbb235");

        cursoModel.update(curso);

        //5) Delete
        alunoModel.delete(aluno2);
        cursoModel.delete(curso2);
    }
}
