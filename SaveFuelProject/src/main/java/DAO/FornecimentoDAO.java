/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Fornecimento;
/**
 *
 * @author J Nogueira
 */
public class FornecimentoDAO {
    private static FornecimentoDAO instance;
       protected EntityManager entityManager;

       public static FornecimentoDAO getInstance(){
         if (instance == null){
            instance = new FornecimentoDAO();
         }

         return instance;
       }

       private FornecimentoDAO() {
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

       public Fornecimento getById(final int id) {
         return entityManager.find(Fornecimento.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Fornecimento> findAll() {
         return entityManager.createQuery("FROM " +
         Fornecimento.class.getName()).getResultList();
       }

       public void persist(Fornecimento fornecimento) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Fornecimento fornecimento) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(fornecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Fornecimento fornecimento) {
         try {
            entityManager.getTransaction().begin();
            fornecimento = entityManager.find(Fornecimento.class, fornecimento.getId());
            entityManager.remove(fornecimento);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Fornecimento fornecimento = getById(id);
            remove(fornecimento);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
