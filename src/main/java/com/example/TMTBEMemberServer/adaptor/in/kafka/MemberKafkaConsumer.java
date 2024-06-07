package com.example.TMTBEMemberServer.adaptor.in.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


@Slf4j
public class MemberKafkaConsumer {

    private static String TOPIC_NAME = "kakaopay-event";
    private static String BOOTSTRAP_SERVERS = "localhost:9092";
    private static String GROUP_ID = "kafka-consumer-group";

    public void consumer(){

        Properties config = new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,GROUP_ID); //group id 설정
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false); //Auto commit = false

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config); //컨슈머 생성
        consumer.subscribe(Arrays.asList(TOPIC_NAME)); //해당 토픽내용 구독

        while (true) { //
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for(ConsumerRecord<String, String> record : records) {
                log.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
                consumer.commitAsync(); //오프셋 비동기적으로 commit
                record.offset(); //오프셋 읽기
            }
        }
    }
}
