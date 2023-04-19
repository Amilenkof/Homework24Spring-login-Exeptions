import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import service.AccountService;
import service.AccountServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountService accountService=new AccountServiceImpl();
        String login= scanner.nextLine();
        String password = scanner.nextLine();
        String confirmPassword = scanner.nextLine();
        try {

            System.out.println("результат "+ accountService.checkAccountSets(login, password, confirmPassword));
        }catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }

    }
}
