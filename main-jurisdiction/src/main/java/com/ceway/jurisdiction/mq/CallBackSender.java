package com.ceway.jurisdiction.mq;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
	@Autowired
	private RabbitTemplate rabbitTemplate;
 
	public void send(String topic, String message) {
		rabbitTemplate.setConfirmCallback(this);
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
 
		System.out.println("消息id:" + correlationData.getId());
		// 用RabbitMQ发送MQTT需将exchange配置为amq.topic
		this.rabbitTemplate.convertAndSend("amq.topic", topic, message, correlationData);
	}
 
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("消息id:" + correlationData.getId());
		if (ack) {
			System.out.println("消息发送确认成功");
		} else {
			System.out.println("消息发送确认失败:" + cause);
		}
	}
 
	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode
				+ ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
	}

}