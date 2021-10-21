package com.pineapple.kafka.domain.usecases;

import com.pineapple.kafka.domain.Message;
import com.pineapple.kafka.domain.usecases.ports.MessageDataProvider;

public class SendMessageUseCase {

  private final MessageDataProvider messageDataProvider;

  public SendMessageUseCase(MessageDataProvider messageDataProvider) {
    this.messageDataProvider = messageDataProvider;
  }

  public void sendMessage(Message message) {
    this.messageDataProvider.sendMessage(message);
  }
}
