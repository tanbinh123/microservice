package com.javaweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
    public String test() {
        return "success";
    }
    
    @GetMapping("/notFound")
    public String notFound() {
        return "请求的地址不存在";
    }

}
