package org.example.controller;

import org.example.domain.Topic;
import org.example.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @GetMapping("/topics")
    public List<Topic>getAllTopics(){
        return topicService.getAllTopics();
    }
    @GetMapping("/topics/{topicsId}")
    public Topic getTopicsDetail(@PathVariable Long TopicsId){
        return topicService.getTopicsDetails(TopicsId);
    }
    @PostMapping("/addTopics")
    public Topic addTopics(@RequestBody Topic topic){
        return topicService.addTopics(topic);
    }
    @PutMapping("/updateTopic/{topicId}")
    public Topic updateTopic(@PathVariable Long topicId,@RequestBody Topic topic){
        return topicService.updateTopic(topicId,topic);
    }
    @DeleteMapping("/deleteTopic/{topicId}")
    public Topic deleteTopic(@PathVariable Long topicId){
        return topicService.deleteTopic(topicId);
    }
}
