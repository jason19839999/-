package com.imooc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestDealController {

    @RequestMapping(value = "/NoAuthority")
    public String NoAuthority() {
        return "您没有权限访问";
    }


}
