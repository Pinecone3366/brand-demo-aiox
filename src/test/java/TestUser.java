import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;

public class TestUser {
    @org.junit.Test
    public void TestLogin() {
        String userName;
        String passWord;
        Scanner scanner = new Scanner(System.in);

        System.out.print("�������û���:");
        userName = scanner.nextLine();
        System.out.println();
        System.out.print("����������:");
        passWord = scanner.nextLine();


    }

    @org.junit.Test
    public void TestUserName() {


        final String content = "Aa011111111";

        final String pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("�ַ������Ƿ������ 'runoob' ���ַ���? " + isMatch);
    }

}


