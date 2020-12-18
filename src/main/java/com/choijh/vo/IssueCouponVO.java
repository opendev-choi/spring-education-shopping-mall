package com.choijh.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IssueCouponVO {
    int couponId;
    int userId;

    @Override
    public String toString() {
        return String.format(
                "IssueCouponVO[couponId=%d, userId=%d]",
                this.couponId, this.userId
        );
    }
}
