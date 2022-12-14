/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Fornecedor;
/**
 *
 * @author J Nogueira
 */
public class FornecedorDAO {
    private static FornecedorDAO instance;
       protected EntityManager entityManager;

       public static FornecedorDAO getInstance(){
         if (instance == null){
            instance = new FornecedorDAO();
         }

         return instance;
       }

       private FornecedorDAO() {
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

       public Fornecedor getById(final int id) {
         return entityManager.find(Fornecedor.class, id);
       }

       @SuppressWarnings("unchecked")
       public List<Fornecedor> findAll() {
         return entityManager.createQuery("FROM " +
         Fornecedor.class.getName()).getResultList();
       }

       public void persist(Fornecedor fornecedor) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Fornecedor fornecedor) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(fornecedor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Fornecedor fornecedor) {
         try {
            entityManager.getTransaction().begin();
            fornecedor = entityManager.find(Fornecedor.class, fornecedor.getId());
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final int id) {
         try {
            Fornecedor fornecedor = getById(id);
            remove(fornecedor);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}
