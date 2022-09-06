package org.example.topic;

import org.springframework.data.repository.CrudRepository;

public interface  TopicRepository extends CrudRepository<Topic,String> {

    //getAllTopics()
    //getTopic(String id)
    //UpdateTopic(Topic t)
    //deleteTopic(String id)

}
