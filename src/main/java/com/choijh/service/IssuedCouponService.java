package com.choijh.service;

import com.choijh.model.Coupon;
import com.choijh.model.IssuedCoupon;
import com.choijh.util.DateUtil;
import com.choijh.repository.CouponRepository;
import com.choijh.repository.IssuedCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Optional;

@Controller
public class IssuedCouponService {
    private final IssuedCouponRepository issuedCouponRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public IssuedCouponService(IssuedCouponRepository issuedCouponRepository, CouponRepository couponRepository) {
        this.issuedCouponRepository = issuedCouponRepository;
        this.couponRepository = couponRepository;
    }

    public IssuedCoupon issueCouponById(int issueCouponId) throws Exception {
        return this.issuedCouponRepository.findById(issueCouponId)
                .orElseThrow(() -> new Exception("해당 발급된 쿠폰 ID가 없습니다"));
    }

    public int issueCoupon(int couponId, int userId) throws Exception {
        Optional<Coupon> SearchedCoupon = this.couponRepository.findById(couponId);
        Coupon coupon = SearchedCoupon.orElseThrow(() -> new Exception("해당 쿠폰을 찾지 못하였습니다."));

        Date expireDate = null;
        Date addedDate = DateUtil.addDays(new Date(), coupon.getAvailableDays());

        int compareDate = addedDate.compareTo(coupon.getExpireAt());
        if (compareDate == 1) {
            expireDate = coupon.getExpireAt();
        }
        else if (compareDate == -1){
            expireDate = addedDate;
        }
        else {
            expireDate = addedDate;
        }

        IssuedCoupon issuedCoupon = IssuedCoupon.builder()
                .couponId(couponId)
                .expiredAt(expireDate)
                .userId(userId)
                .build();

        this.issuedCouponRepository.save(issuedCoupon);
        this.issuedCouponRepository.flush();

        return issuedCoupon.getIssuedCouponId();
    }

}
