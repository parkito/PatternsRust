package com.coding.play.tasks;

import java.util.Collection;
import java.util.List;

public class Task5 {

    enum State {
        CANCELED
    }

    class Transaction {
        boolean isCanceled;
        int sum;
        State state;

        public State getState() {
            return state;
        }

        public int getSum() {
            return sum;
        }
    }

    class Account {
        int balance;
        List<Transaction> transactions;

        public int getBalance() {
            return balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }

    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.getBalance() > 0)
                .map(Account::getTransactions)
                .flatMap(Collection::stream)
                .filter(t -> t.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();
    }
}
