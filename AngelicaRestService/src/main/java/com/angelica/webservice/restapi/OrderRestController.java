package com.angelica.webservice.restapi;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelica.exceptions.NoProductException;
import com.angelica.model.Order;
import com.angelica.service.OrderService;
import com.angelica.webservice.restapi.common.BaseResponse;
import com.angelica.webservice.restapi.wrapper.AddOrderRequestWrapper;
import com.angelica.webservice.restapi.wrapper.ProductDetail;

@RestController
public class OrderRestController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/AddOrder/{id}", method = RequestMethod.POST)
	public AddOrderResponse addOrder(@RequestBody AddOrderRequestWrapper orderReq, @PathVariable("id") Long customerId) {
		AddOrderResponse response = new AddOrderResponse();
		try {
			
			List<ProductDetail> productsToOrder = orderReq.getProductsToOrder().stream().collect(Collectors.toList());

			if(productsToOrder.size()<1){ throw new NoProductException("No products were received during order generation...");}
			
			Date deliveryDate = orderService.generateProductsOrder(customerId, orderReq.getDeliveryAddress(), productsToOrder);

			response.returnCode = 0;
			response.returnMessage = "success";
			response.addOrderMessage = "a new order has been added for customer " + customerId;
			response.deliveryDate = "" + deliveryDate;
		} catch (NoProductException npe){
			npe.getMessage();
			response.returnCode = 2;
			response.returnMessage = npe.getMessage();
			response.addOrderMessage = "no order was generated for customer " + customerId;
			
		}catch (Exception e) {
			e.getMessage();
			response.returnCode = 1;
			response.returnMessage = "Exception during adding the order";
			response.addOrderMessage = "no order was generated for customer " + customerId;
		}
		return response;
	}
	
	@RequestMapping(value = "/GetOrdersByCustomer/{id}", method = RequestMethod.GET)
	public GetOrderResponse getOrdersByCustomer(@PathVariable("id") Long customerId){
		GetOrderResponse response = new GetOrderResponse();
		try{
			response.returnCode = 0;
			response.returnMessage = "orders for customer " + customerId + " have been retrieved successfully";
			response.customerId = customerId;
			response.orders = orderService.getOrdersByCustomer(customerId);
			
		}catch(Exception e){
			response.returnCode = 1;
			response.returnMessage = "Exception getting orders for customer " + customerId;
		}
		return response;
	}

	class AddOrderResponse extends BaseResponse {
		public String addOrderMessage;
		public String deliveryDate;
	}
	
	class GetOrderResponse extends BaseResponse{
		public Long customerId;
		public List<Order> orders;
	}


}
