package com.angelica.webservice.restapi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {

    @RequestMapping(value = "/TestParams", method = RequestMethod.GET)
    public Response testParams() {
        System.out.println("TestParams rest controller called");
        Response response = new Response();
        response.code = "0";
        response.message = "exito";
        return response;
    }

    static class Request {
        public String userId;
        public String password;
    }

    class Response {
        public String code;
        public String message;
    }

}


