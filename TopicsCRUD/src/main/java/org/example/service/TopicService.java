package org.example.service;

import org.example.domain.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TopicService {
    private static Map<Long,Topic> topics=new HashMap<>();


    private static Long index=2L;
    static {
        Topic top1=new Topic(1L,"Java","java basic");
        topics.put(1L,top1);
    }

    public static List<Topic> getAllTopics() {
        return new ArrayList<>(topics.values());
    }

    public static Topic getTopicsDetails(Long topicsId) {
        return topics.get(topicsId);
    }

    public static Topic addTopics(Topic topic) {
        topic.setId(index);
        topics.put(index,topic);
        index++;
        return null;

    }

    public static Topic updateTopic(Long topicId, Topic topic) {
        topic.setId(topicId);
        topics.put(topicId,topic);
        return topic;
    }

    public static Topic deleteTopic(Long topicId) {
         topics.remove(topicId);
         return null;
    }
}
