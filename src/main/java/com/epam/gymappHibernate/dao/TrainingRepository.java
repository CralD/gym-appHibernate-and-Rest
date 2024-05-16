package com.epam.gymappHibernate.dao;



import com.epam.gymappHibernate.entity.Training;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TrainingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveTraining(Training training){
        entityManager.persist(training);
    }
    public List<Training> getTraineeTrainings(String username, Date fromDate, Date toDate, String trainerName, String trainingType){
        String queryString = "SELECT t FROM Training t JOIN t.trainee trn JOIN t.trainer tr JOIN t.trainingType tt WHERE trn.username = :username" +
                " AND t.date >= :fromDate AND t.date <= :toDate AND tr.name = :trainerName AND tt.type = :trainingType";
        TypedQuery<Training> query = entityManager.createQuery(queryString, Training.class);
        query.setParameter("username", username);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        query.setParameter("trainerName", trainerName);
        query.setParameter("trainingType", trainingType);
        return query.getResultList();
    }
    public List<Training> getTrainerTrainings(String username, Date fromDate, Date toDate, String traineeName){
        String queryString = "SELECT t FROM Training t JOIN t.trainer tr JOIN t.trainee trn WHERE tr.username = :username" +
                " AND t.date >= :fromDate AND t.date <= :toDate AND trn.name = :traineeName";
        TypedQuery<Training> query = entityManager.createQuery(queryString, Training.class);
        query.setParameter("username", username);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        query.setParameter("traineeName", traineeName);
        return query.getResultList();
    }

}