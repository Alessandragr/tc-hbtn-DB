package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno1 = em.find(Aluno.class, aluno.getId());

        em.getTransaction().begin();
        em.merge(aluno1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno1 = em.find(Aluno.class, aluno.getId());

        em.getTransaction().begin();
        em.remove(aluno1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public Aluno findById(Aluno aluno) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno1 = em.find(Aluno.class, aluno.getId());

        return aluno1;
    }

    public List<Aluno> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM" + Aluno.class.getName()).getResultList();
    }
}
