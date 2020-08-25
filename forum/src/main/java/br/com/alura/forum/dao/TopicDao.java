package br.com.alura.forum.dao;

import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface TopicDao extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic> {

    @Query("select t from Topic t") // JPQL
    List<Topic> list();

    List<Topic> findAll();


    @Query("SELECT count(topic) FROM Topic topic "
            + "JOIN topic.course course "
            + "JOIN course.subcategory subcategory "
            + "JOIN subcategory.category category "
            + "WHERE category.id = :categoryId")
    Integer countTopicsByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT count(topic) FROM Topic topic "
            + "JOIN topic.course course "
            + "JOIN course.subcategory subcategory "
            + "JOIN subcategory.category category "
            + "WHERE category.id = :categoryId AND topic.status = :status")
    Integer countTopicsByCategoryIdAndStatus(@Param("categoryId") Long categoryId,
                                             @Param("status")TopicStatus status);

    @Query("SELECT count(topic) FROM Topic topic "
            + "JOIN topic.course course "
            + "JOIN course.subcategory subcategory "
            + "JOIN subcategory.category category "
            + "WHERE category.id = :categoryId AND topic.creationInstant > :lastWeek")
    Integer countLastWeekTopicsByCategoryId(@Param("categoryId") Long categoryId,
                                            @Param("lastWeek")Instant lastWeek);

    void save(Topic topic);



}
