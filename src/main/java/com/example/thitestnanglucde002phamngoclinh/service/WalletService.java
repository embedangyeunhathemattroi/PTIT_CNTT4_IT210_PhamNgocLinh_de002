package com.example.thitestnanglucde002phamngoclinh.service;

import com.example.thitestnanglucde002phamngoclinh.entity.Wallet;
import com.example.thitestnanglucde002phamngoclinh.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    // chuyển tiền
    @Transactional
    public void transferMoney(Long fromId, Long toId, BigDecimal amount) {

        Wallet from = walletRepository.findById(fromId).orElseThrow();
        from.setBalance(from.getBalance().subtract(amount));
        walletRepository.save(from);

        // giả lập lỗi
        if (true) {
            throw new RuntimeException("Lỗi khi chuyển tiền");
        }

        Wallet to = walletRepository.findById(toId).orElseThrow();
        to.setBalance(to.getBalance().add(amount));
        walletRepository.save(to);
    }

    // log riêng
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveSystemLog(String msg) {
        System.out.println("LOG: " + msg);
    }
}