package com.pineapple.kafka.domain.usecases.ports;

import com.pineapple.kafka.domain.Message;

public interface MessageDataProvider {

  void sendMessage(Message message);
}
