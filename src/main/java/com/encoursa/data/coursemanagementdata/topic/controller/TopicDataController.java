package com.encoursa.data.coursemanagementdata.topic.controller;


import com.encoursa.data.coursemanagementdata.topic.models.Topic;
import com.encoursa.data.coursemanagementdata.topic.servrice.TopicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TopicDataController {

    @Autowired
    private TopicDataService topicServices;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicServices.getTopics();
    }

    @RequestMapping("/topic/{identifier}")
    public Topic getTopic(@PathVariable("identifier") String id) {
        return topicServices.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopics(@RequestBody Topic topic) {
      topicServices.addTopic(topic);

    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topic/{id}")
    public void updateTopic(@PathVariable String id ,@RequestBody Topic topic){
        topicServices.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topic/{id}")
    public void deleteTopic(@PathVariable String id){
        Topic topic = topicServices.getTopic(id);
        if(topic != null ) {
            topicServices.deleteTopic(topic);
        }
    }
}
