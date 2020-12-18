package com.choijh.service;

import com.choijh.model.Coupon;
import com.choijh.model.IssuedCoupon;
import com.choijh.util.DateUtil;
import com.choijh.repository.CouponRepository;
import com.choijh.repository.IssuedCouponRepository;
import com.choijh.vo.IssueCouponVO;
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

    public int issueCoupon(IssueCouponVO issueCouponVO) throws Exception{
        Optional<Coupon> SearchedCoupon = this.couponRepository.findById(issueCouponVO.getCouponId());
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
                .couponId(issueCouponVO.getCouponId())
                .expiredAt(expireDate)
                .userId(issueCouponVO.getUserId())
                .build();

        this.issuedCouponRepository.save(issuedCoupon);
        this.issuedCouponRepository.flush();

        return issuedCoupon.getIssuedCouponId();
    }

}
