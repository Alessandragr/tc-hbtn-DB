package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {
    public void create(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso1 = em.find(Curso.class, curso.getId());

        em.getTransaction().begin();
        em.merge(curso1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso1 = em.find(Curso.class, curso.getId());

        em.getTransaction().begin();
        em.remove(curso1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public Curso findById(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso1 = em.find(Curso.class, curso.getId());

        return curso1;
    }

    public List<Curso> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM" + Curso.class.getName()).getResultList();
    }
}
