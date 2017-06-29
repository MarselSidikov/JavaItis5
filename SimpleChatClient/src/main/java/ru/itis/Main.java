package ru.itis;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final String TOKEN = "llhd8gXGqkpBZWfKhGac";
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        template.setMessageConverters(converters);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Auth-Token", TOKEN);

        Runnable sendMessageTask = () -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String messageText = scanner.next();
                MessageDto message = new MessageDto();
                message.setMessage(messageText);
                HttpEntity<MessageDto> request = new HttpEntity<>(message, headers);
                template.postForEntity("http://localhost:8080/messages", request, Void.class );
            }
        };

        Runnable getMessagesTask = () -> {
            while (true) {
                HttpEntity entity = new HttpEntity(headers);
                System.out.println("get messages");
                ResponseEntity<MessagesDto> response = template.exchange(
                        "http://localhost:8080/messages", HttpMethod.GET, entity, MessagesDto.class);
                if (response.getBody().getMessages().size() != 0) {
                    System.out.println(response.getBody().getMessages());
                }
            }
        };

        Thread sendMessages = new Thread(sendMessageTask);
        Thread getMessages = new Thread(getMessagesTask);
        sendMessages.start();
        getMessages.start();
    }
}
