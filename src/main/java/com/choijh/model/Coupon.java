package com.choijh.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int couponId;

    @Column
    Date expireAt;

    @Column
    String productID;

    @Column
    String category;

    @Column
    int discountPrice = 0;

    @Column
    int discountPercentage = 0;
}
