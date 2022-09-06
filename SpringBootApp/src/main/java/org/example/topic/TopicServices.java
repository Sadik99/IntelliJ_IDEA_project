package org.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicServices {

    @Autowired
    private TopicRepository topicRepository;
   private List<Topic>topicList= new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("JS","JS FrameWork","JS Framework Description")
        ));
   public List<Topic> getAllTopics(){
       List<Topic>topics=new ArrayList<>();
       //return topicList;
       topicRepository.findAll().forEach(topics::add);
       return topics;
   }
    public Topic getTopic(String id){
        //return topicList.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();

    }

    public void addTopic(Topic topic) {

//       topicList.add(topic);
//        List<Topic>topics=new ArrayList<>();
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic,String id) {

//        for(int i=0;i<topicList.size();i++){
//            Topic t=topicList.get(i);
//            if(t.getId().equals(id)){
//                topicList.set(i,topic);
//                return;
//            }
        topicRepository.save(topic);

    }

    public void deleteTopic( String id) {
       topicRepository.deleteById(id);
    }
}
