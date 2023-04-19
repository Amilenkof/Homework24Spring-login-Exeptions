package service;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class AccountServiceImpl implements AccountService {

    @Override
    public boolean checkAccountSets(String login, String password, String confirmPassword) {
        boolean dataIsGood = false;
        boolean passCompare=password.equals(confirmPassword);

            if (!passCompare){
                throw new WrongPasswordException("Пароли не совпадают");
            }

        dataIsGood = checkSymbols(login) &&
                checkSymbols(password) &&
                checkLoginLenght(login) &&
                checkPasswordLenght(password);
        return dataIsGood;

    }

    public boolean checkLoginLenght(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        return true;

    }

    public boolean checkPasswordLenght(String password) {
        if (password.length() >= 20) {
            throw new WrongLoginException("Пароль слишком длинный");
        }
        return true;
    }

    public boolean checkSymbols(String s) {
        s = s.toLowerCase();
        char c;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                counter++;
            } else if (Character.isAlphabetic(c)) {
                counter++;
            } else if (c == '_') {
                counter++;
            }
        }
        if (counter == s.length()) {
            return true;
        }
        return false;
    }


}

