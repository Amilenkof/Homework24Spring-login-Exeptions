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
        System.out.println("результат "+ accountService.checkAccountSets(login, password, confirmPassword));

    }
}
