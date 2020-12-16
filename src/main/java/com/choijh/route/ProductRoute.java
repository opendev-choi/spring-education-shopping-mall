package com.choijh.route;

import com.choijh.model.Product;
import com.choijh.service.ProductService;
import com.choijh.vo.ProductRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    @ResponseBody
    public Product getProduct(@PathVariable(value="product_id") String productId) throws Exception {
        return this.productService.find(Integer.parseInt(productId));
    }

    @GetMapping("/initialize")
    public void initializeProducts() {
        this.productService.initializeProducts();
    }

    @DeleteMapping("/{product_id}")
    public void deleteProduct(@PathVariable(value="product_id") String productId) throws Exception {
        this.productService.deleteProduct(Integer.parseInt(productId));
    }

    @PostMapping
    public void createProduct(ProductRegisterVO productRegisterVO) {
        this.productService.createProduct(productRegisterVO);
    }
}