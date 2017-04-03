package com.banadiga.hibot;

import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class HiBot extends Bot {

  @Value("${slackBotToken}")
  private String slackToken;


  @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
  public void onHi(WebSocketSession session, Event event) {
    if (event.getText().toLowerCase().contains("hi")) {
      reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName()));
    }
    stopConversation(event);
  }

  @Controller(pattern = "(setup meeting)", next = "confirmTiming", events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
  public void setupMeeting(WebSocketSession session, Event event) {
    startConversation(event, "confirmTiming");
    reply(session, event, new Message("Cool! At what time (ex. 15:30) do you want me to set up the meeting?"));
  }

  @Controller(next = "askTimeForMeeting", events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
  public void confirmTiming(WebSocketSession session, Event event) {
    reply(session, event, new Message("Your meeting is set at "
                                      + event.getText()
                                      + ". Would you like to repeat it tomorrow?"));
    nextConversation(event);
  }

  @Controller(next = "askWhetherToRepeat", events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
  public void askTimeForMeeting(WebSocketSession session, Event event) {
    if (event.getText().toLowerCase().contains("yes")) {
      reply(session, event, new Message("Okay. Would you like me to set a reminder for you?"));
      nextConversation(event);
    } else {
      reply(session, event, new Message("No problem. You can always schedule one with 'setup meeting' command."));
      stopConversation(event);
    }
  }

  @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
  public void askWhetherToRepeat(WebSocketSession session, Event event) {
    if (event.getText().toLowerCase().contains("yes")) {
      reply(session, event, new Message("Great! I will remind you tomorrow before the meeting."));
    } else {
      reply(session, event, new Message("Oh! my boss is smart enough to remind himself :)"));
    }
    stopConversation(event);
  }

  @Override
  public String getSlackToken() {
    return slackToken;
  }

  @Override
  public Bot getSlackBot() {
    return this;
  }
}
