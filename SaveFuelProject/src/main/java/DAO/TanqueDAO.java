/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Tanque;
/**
 *
 * @author J Nogueira
 */
public class TanqueDAO {
    private static TanqueDAO instance;
       protected EntityManager entityManager;

       public static TanqueDAO getInstance(){
         if (instance == null){
            instance = new TanqueDAO();
         }

         return instance;
       }

       private TanqueDAO() {
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

       public Tanque getById(final int id) {
         return entityManager.find(Tanque.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Tanque> findAll() {
         return entityManager.createQuery("FROM " +
         Tanque.class.getName()).getResultList();
       }

       public void persist(Tanque viatura) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(viatura);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Tanque tanque) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(tanque);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Tanque tanque) {
         try {
            entityManager.getTransaction().begin();
            tanque = entityManager.find(Tanque.class, tanque.getId());
            entityManager.remove(tanque);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Tanque tanque = getById(id);
            remove(tanque);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
