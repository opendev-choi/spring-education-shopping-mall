package com.choijh.datamodel.dto;

import com.choijh.datamodel.enumModel.SaleStatusEnum;
import com.choijh.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SaleDTO {
    private int saleId;
    private int userId;
    private int productId;
    private int paidPrice;
    private int listPrice;
    private int amount;
    private SaleStatusEnum status = SaleStatusEnum.NON_PAID;

    public SaleDTO(Sale sale) {
        this.saleId = sale.getSaleId();
        this.userId = sale.getUserId();
        this.productId = sale.getProductId();
        this.paidPrice = sale.getPaidPrice();
        this.listPrice = sale.getListPrice();
        this.amount = sale.getAmount();
        this.status = sale.getStatus();
    }

    @Override
    public String toString() {
        return String.format(
                "SaleDTO[saleId=%d, userId=%d, productId=%d, paidPrice=%d, listPrice=%d, amount=%d, status='%s']",
                this.saleId, this.userId, this.productId, this.paidPrice, this.listPrice, this.amount, this.status
        );
    }
}
