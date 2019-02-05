package com.coding.play.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task7 {

    class Account{
        String number;
        Long balance;

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }
    }

    class Transaction{
        String uuid;
        Long sum;
        Account account;

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        Map<String, Long> totalSumOfTransByEachAccount =
                transactions.stream()
                        .collect(Collectors.groupingBy(t->t.account.number, Collectors.summingLong(Transaction::getSum)));
    }
}
