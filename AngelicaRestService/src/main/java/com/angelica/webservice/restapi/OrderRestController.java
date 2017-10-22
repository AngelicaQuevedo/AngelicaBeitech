package com.angelica.webservice.restapi;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelica.model.Customer;
import com.angelica.webservice.restapi.common.BaseResponse;

@RestController
public class OrderRestController {

    @RequestMapping(value = "/AddOrder", method = RequestMethod.POST)
    public OrderResponse addOrder(@RequestBody AddOrderRequest orderReq) {
    	OrderResponse response = new OrderResponse();
        response.returnCode = 0;
        response.returnMessage = "exito";
        return response;
    }
    
    @RequestMapping(value = "/GetOrdersByCustomer", method = RequestMethod.POST)
    public OrderResponse getOrdersByCustomer(@RequestBody OrdersByCustomerRequest orderReq){
    	OrderResponse response = new OrderResponse();
    	response.returnCode = 0;
        response.returnMessage = "exito";
        return response;
    }
    
    class OrderResponse extends BaseResponse {
        public List<Customer> customers;
    }
    
    class AddOrderRequest{
    	public Integer customerId;
    	
    }
    
    class OrdersByCustomerRequest{
    	public Integer customerId;
    	public LocalDate initDate;
    	public LocalDate endDate;
    }

}
