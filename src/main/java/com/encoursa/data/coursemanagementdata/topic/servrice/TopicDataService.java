package com.encoursa.data.coursemanagementdata.topic.servrice;


import com.encoursa.data.coursemanagementdata.topic.models.Topic;
import com.encoursa.data.coursemanagementdata.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicDataService {
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        Iterable<Topic> topicIterable = topicRepository.findAll();
        if(topicIterable != null){
            topicIterable.forEach(topics :: add);        }
        return topics;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic getTopic(String id){

        Topic topic = null;

        Optional<Topic> byId = topicRepository.findById(id);

        if (byId.isPresent()){
            topic = byId.get();
        }

        return topic;
    }

    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }


}
