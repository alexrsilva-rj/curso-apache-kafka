package br.com.alexrsilva.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {
    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"0"})
            }, containerFactory = "strContainerFactory")
    public void listener(String message) {
        log.info("CREATE :: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"1"})
            }, containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info(" LOG ::Receive message {}", message);
    }
}

