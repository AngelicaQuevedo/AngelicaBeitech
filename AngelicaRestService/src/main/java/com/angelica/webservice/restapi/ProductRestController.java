package com.angelica.webservice.restapi;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.angelica.model.Product;
import com.angelica.webservice.restapi.common.BaseResponse;

@RestController
public class ProductRestController {
	
	class AllowedProductsResponse extends BaseResponse {
        public List<Product> products;
    }

}
