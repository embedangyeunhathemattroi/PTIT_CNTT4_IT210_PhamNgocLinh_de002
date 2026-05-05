package com.example.thitestnanglucde002phamngoclinh.controller;
import com.example.thitestnanglucde002phamngoclinh.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/transfer")
    @ResponseBody
    public String transferMoney(
            @RequestParam Long from,
            @RequestParam Long to,
            @RequestParam BigDecimal amount
    ) {
        try {
            walletService.transferMoney(from, to, amount);
            return "Chuyển tiền thành công";
        } catch (Exception e) {
            walletService.saveSystemLog("Lỗi chuyển tiền: " + e.getMessage());

            return "Chuyển tiền thất bại!";
        }
    }
}