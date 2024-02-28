package com.example.testlgle.controller;

import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller

public class testController {
    @RequestMapping(value = "/get")
    public String index(){
        return "index1";
    }


    @GetMapping("/test")
    public String getToken(String code){
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("client_id", Constants.GOOGLE_CLIENT_ID);
        requestBody.add("client_secret", Constants.GOOGLE_CLIENT_SECRET);
        requestBody.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI);
        requestBody.add("code", code);
        requestBody.add("grant_type", Constants.GOOGLE_GRANT_TYPE);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.postForObject(Constants.GOOGLE_LINK_GET_TOKEN, requestEntity, String.class);
        Gson gson = new Gson();
        json js = gson.fromJson(response, json.class);

        String res = js.getAccess_token();
        getUserInfo(res);
        return res;
    }

    public String getUserInfo(String access_token){
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + access_token;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(link, String.class);
        return null;
    }
}
