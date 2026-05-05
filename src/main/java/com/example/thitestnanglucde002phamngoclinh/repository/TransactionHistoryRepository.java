package com.example.thitestnanglucde002phamngoclinh.repository;

import com.example.thitestnanglucde002phamngoclinh.entity.TransactionHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    // 1. Method Query + Paging
    Page<TransactionHistory> findByWalletId(Long walletId, Pageable pageable);

    // 2. Custom Query (JPQL)
    @Query("SELECT t FROM TransactionHistory t WHERE t.amount > :amount")
    List<TransactionHistory> findByAmountGreaterThan(@Param("amount") BigDecimal amount);
}