package com.pineapple.kafka.infraestructure.entrypoints.dataprovider;

import com.pineapple.kafka.domain.Message;
import com.pineapple.kafka.domain.usecases.ports.MessageDataProvider;
import com.pineapple.kafka.infraestructure.entrypoints.services.TopicProducer;
import org.springframework.stereotype.Component;

@Component
public class MessageDataProviderImpl implements MessageDataProvider {

  private final TopicProducer topicProducer;

  public MessageDataProviderImpl(final TopicProducer topicProducer) {
    this.topicProducer = topicProducer;
  }

  @Override
  public void sendMessage(Message message) {
    this.topicProducer.sendMessage(message);
  }
}
