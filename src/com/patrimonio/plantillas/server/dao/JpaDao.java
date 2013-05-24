package com.patrimonio.plantillas.server.dao;


import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaDao<PK, E>{

        @PersistenceContext        
        private EntityManager entityManager;
        
        protected Class<E> entityClass;
        
        @SuppressWarnings("unchecked")
        public JpaDao() {
                
                System.out.println("JpaDao => constructor()");
                ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
                this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
                System.out.println("EntityClass " + this.entityClass);
        }

        public E persist(E entity) {
                entityManager.persist(entity);
                return entity;
        }

        public void remove(E entity) {
                entityManager.remove(entity);
        }

        public E merge(E entity) {
                return entityManager.merge(entity);
        }

        public void refresh(E entity) {
                entityManager.refresh(entity);
        }

        public E findById(PK id) {
                return entityManager.find(entityClass, id);
        }

        public E flush(E entity) {
                entityManager.flush();
                return entity;
        }

        @SuppressWarnings("unchecked")
        public List<E> findAll() {
//              Object res = entityManager.execute(new JpaCallback() {
//                      public Object doInJpa(EntityManager em) throws PersistenceException {
//                              Query q = em.createQuery("SELECT h FROM " + entityClass.getName() + " h");
//                              return q.getResultList();
//                      }
//              });
//              return (List<E>) res;
                return new ArrayList<E>();
        }

}
