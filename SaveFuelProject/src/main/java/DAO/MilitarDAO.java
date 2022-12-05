/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Militar;
/**
 *
 * @author J Nogueira
 */
public class MilitarDAO {
    private static MilitarDAO instance;
       protected EntityManager entityManager;

       public static MilitarDAO getInstance(){
         if (instance == null){
            instance = new MilitarDAO();
         }

         return instance;
       }

       private MilitarDAO() {
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

       public Militar getById(final int id) {
         return entityManager.find(Militar.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Militar> findAll() {
         return entityManager.createQuery("FROM " +
         Militar.class.getName()).getResultList();
       }

       public void persist(Militar militar) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(militar);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Militar militar) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(militar);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Militar militar) {
         try {
            entityManager.getTransaction().begin();
            militar = entityManager.find(Militar.class, militar.getId());
            entityManager.remove(militar);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Militar militar = getById(id);
            remove(militar);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
