package com.pineapple.kafka.infraestructure.entrypoints.services;

import com.pineapple.kafka.domain.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

  private final KafkaTemplate<String, String> kafkaTemplateProducer;
  private final String topicName;

  public TopicProducer(
      final @Qualifier("kafkaTemplateProducer") KafkaTemplate<String, String> kafkaTemplateProducer,
      @Value("${kafka.producer.topic-name}") String topicName) {
    this.kafkaTemplateProducer = kafkaTemplateProducer;
    this.topicName = topicName;
  }

  public void sendMessage(Message message) {
    this.kafkaTemplateProducer.send(topicName, message.getContent());
  }
}
