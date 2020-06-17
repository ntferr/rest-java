package com.example.demo;

import com.example.demo.BoredModel;
import com.example.demo.Time;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class BoredController {
    
	@GetMapping("/v1")
	public BoredModel getBoredModel(RestTemplate restTemplate) {
		Time time = new Time(00, 20, 30);
		
		String url = "http://www.boredapi.com/api/activity?";
        List<String> types = time.acessTime();
        
        for (String type : types) {
            url += type;
        }
        BoredModel boredModel = restTemplate.getForObject(url, BoredModel.class);  
		return boredModel;
	}
}