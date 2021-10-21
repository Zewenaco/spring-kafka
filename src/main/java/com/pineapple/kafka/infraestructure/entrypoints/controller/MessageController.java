package com.pineapple.kafka.infraestructure.entrypoints.controller;

import com.pineapple.kafka.domain.Message;
import com.pineapple.kafka.domain.usecases.SendMessageUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

  private final SendMessageUseCase sendMessageUseCase;

  public MessageController(final SendMessageUseCase sendMessageUseCase) {
    this.sendMessageUseCase = sendMessageUseCase;
  }

  @PostMapping
  public void publishMessage(@RequestBody Message message) {
    this.sendMessageUseCase.sendMessage(message);
  }
}
