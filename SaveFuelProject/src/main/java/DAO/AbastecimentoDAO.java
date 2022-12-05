/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Abastecimento;
/**
 *
 * @author J Nogueira
 */
public class AbastecimentoDAO {
    private static AbastecimentoDAO instance;
       protected EntityManager entityManager;

       public static AbastecimentoDAO getInstance(){
         if (instance == null){
            instance = new AbastecimentoDAO();
         }

         return instance;
       }

       private AbastecimentoDAO() {
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

       public Abastecimento getById(final int id) {
         return entityManager.find(Abastecimento.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Abastecimento> findAll() {
         return entityManager.createQuery("FROM " +
         Abastecimento.class.getName()).getResultList();
       }

       public void persist(Abastecimento abastecimento) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(abastecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Abastecimento abastecimento) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(abastecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Abastecimento abastecimento) {
         try {
            entityManager.getTransaction().begin();
            abastecimento = entityManager.find(Abastecimento.class, abastecimento.getId());
            entityManager.remove(abastecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Abastecimento abastecimento = getById(id);
            remove(abastecimento);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
