package br.com.alura.forum.dao;

import br.com.alura.forum.model.topic.domain.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TopicDao extends Repository<Topic, Long> {

    @Query("select t from Topic t") // JPQL
    List<Topic> list();

    List<Topic> findAll();

}