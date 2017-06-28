package ru.itis;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String TOKEN = "llhd8gXGqkpBZWfKhGac";
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        template.setMessageConverters(converters);
        MessageDto message = new MessageDto();
        message.setMessage("Hello from Client");
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Auth-Token", TOKEN);

        HttpEntity<MessageDto> request = new HttpEntity<MessageDto>(message, headers);
        template.postForEntity("http://localhost:8080/messages", request, Void.class );
    }
}
