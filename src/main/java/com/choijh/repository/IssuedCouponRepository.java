package com.choijh.repository;

import com.choijh.model.IssuedCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedCouponRepository extends JpaRepository<IssuedCoupon, Integer> {
}
