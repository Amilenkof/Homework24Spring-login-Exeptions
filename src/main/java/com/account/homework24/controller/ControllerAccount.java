package com.account.homework24.controller;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.account.homework24.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/login")
public class ControllerAccount {
    private static AccountService accountService;

    public ControllerAccount(AccountService accountService) {
        ControllerAccount.accountService = accountService;
    }

    @GetMapping("/check")
    public static boolean checkAccountSets(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        try {
            return accountService.checkAccountSets(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            System.out.println("e.getStackTrace() = " + e.getStackTrace());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("e.getStackTrace() = " + e.getStackTrace());
            return false;
        }

    }
}
