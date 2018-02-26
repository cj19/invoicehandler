package com.darvasroland.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

abstract class EntityRepositoryFacade<T> {

    protected final Class<T> clazz;

    @PersistenceContext(name = "InvoiceHandlerPU")
    private EntityManager entityManager;

    protected EntityRepositoryFacade(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public T create(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(clazz, id);
    }

    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder()
                .createQuery(clazz);
        criteriaQuery.select(criteriaQuery.from(clazz));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public Long count() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(clazz)));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public T delete(Object id) {
        T entity = find(id);
        if (entity != null) {
            getEntityManager().remove(entity);
            return entity;
        } else {
            return null;
        }
    }
}
