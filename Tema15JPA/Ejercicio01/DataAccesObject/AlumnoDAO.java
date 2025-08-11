package Tema15JPA.Ejercicio01.DataAccesObject;

import Tema15JPA.Ejercicio01.persistencia.JPAUtil;
import Tema15JPA.Ejercicio01.dominio.Alumno;

import javax.persistence.EntityManager;
import java.util.List;


public class AlumnoDAO {

    public void guardar(Alumno alumno) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public Alumno buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Alumno alumno = em.find(Alumno.class, id);
        em.close();
        return alumno;
    }

    public List<Alumno> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Alumno> lista = em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        em.close();
        return lista;
    }

    public void actualizar(Alumno alumno) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Alumno alumno = em.find(Alumno.class, id);
        if (alumno != null) {
            em.getTransaction().begin();
            em.remove(alumno);
            em.getTransaction().commit();
        }
        em.close();
    }
}
