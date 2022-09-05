package org.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class TopicController {
    @Autowired
    private TopicServices topicServices;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicServices.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopics(@PathVariable String id) {
        return topicServices.getTopic(id);
    }

    @RequestMapping(method = POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicServices.addTopic(topic);
    }
    @RequestMapping(method = PUT,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicServices.updateTopic(topic,id);
    }
    @RequestMapping(method = DELETE,value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicServices.deleteTopic(id);
    }


}
