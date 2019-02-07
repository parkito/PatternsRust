package com.coding.play.tasks;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Task9 {
    class Account {
        String guid;
        Long balance;

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public Long getBalance() {
            return balance;
        }

        public void setBalance(Long balance) {
            this.balance = balance;
        }
    }

    class User {
        String login;
        Account account;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
    }

    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login)).findFirst();

    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin).map(User::getAccount)
                .ifPresent(u -> {
                    if (u.getBalance() > 0) {
                        System.out.println(userLogin + ": " + u.getBalance());
                    }
                });
    }

    public static void printBalanceIfNotEmptyShort(String userLogin) {
        findUserByLogin(userLogin)
                .map(User::getAccount)
                .map(Account::getBalance)
                .filter(balance -> balance > 0)
                .ifPresent(res -> System.out.println(userLogin + ": " + res));
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>> a =
                (arg1, arg2) -> (arg3, arg4) -> (arg5) -> arg1 + arg2 + arg3 + arg4 + arg5;
    }
}
