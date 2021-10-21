package com.pineapple.kafka.infraestructure.entrypoints.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TopicConsumer {

  private static final Logger log = LoggerFactory.getLogger(TopicConsumer.class);
  private final String topicName;
  private final String groupId;

  public TopicConsumer(
      final @Value("${kafka.consumer.topic-name}") String topicName,
      final @Value("${kafka.consumer.group-id}") String groupId) {
    this.topicName = topicName;
    this.groupId = groupId;
  }

  @KafkaListener(topics = "#{'${kafka.consumer.topic-name}'}", groupId = "#{'${kafka.consumer.group-id}'}")
  public void listenMessage(String message) {
    log.info(
        String.format(
            "Received message in group %s from topic %s: %s", groupId, topicName, message));
  }
}
