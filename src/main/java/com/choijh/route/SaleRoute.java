package com.choijh.route;

import com.choijh.model.Sale;
import com.choijh.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleRoute {
    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/{sale_id}")
    @ResponseBody
    public Sale getSale(@PathVariable(value="sale_id") String saleId) throws Exception{
        return this.saleService.find(Integer.parseInt(saleId));
    }

    @GetMapping("/initialize")
    public void initializeSales() {
        this.saleService.initializeSales();
    }
}
