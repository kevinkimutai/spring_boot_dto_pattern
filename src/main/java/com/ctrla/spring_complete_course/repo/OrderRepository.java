package com.ctrla.spring_complete_course.repo;

import com.ctrla.spring_complete_course.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
