/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Viatura;
/**
 *
 * @author J Nogueira
 */
public class ViaturaDAO {
    private static ViaturaDAO instance;
       protected EntityManager entityManager;

       public static ViaturaDAO getInstance(){
         if (instance == null){
            instance = new ViaturaDAO();
         }

         return instance;
       }

       private ViaturaDAO() {
         entityManager = getEntityManager();
       }

       private EntityManager getEntityManager() {
        EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
          entityManager = factory.createEntityManager();
        }

        return entityManager;
       }

       public Viatura getById(final int id) {
         return entityManager.find(Viatura.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Viatura> findAll() {
         return entityManager.createQuery("FROM " +
         Viatura.class.getName()).getResultList();
       }

       public void persist(Viatura viatura) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(viatura);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Viatura viatura) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(viatura);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Viatura viatura) {
         try {
            entityManager.getTransaction().begin();
            viatura = entityManager.find(Viatura.class, viatura.getId());
            entityManager.remove(viatura);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Viatura viatura = getById(id);
            remove(viatura);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
