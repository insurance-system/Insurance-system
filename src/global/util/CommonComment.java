package global.util;

import java.util.Scanner;

import static global.util.constants.CommonConstants.END_LINE;

public class CommonComment {

    Scanner scanner;

    public CommonComment() {
        this.scanner = new Scanner(System.in);
    }

    public int initial(){
        System.out.println("-------------------- ๐ฅ [ ์ํ์์กฐ ๋ณดํ ] ๐ฅ ---------------------");
        System.out.println("1.๋ณดํ์ฌ ๊ณ ๊ฐ \n2.์ฌ์\n0.์ข๋ฃ");
        System.out.print("๋ฒํธ ์๋ ฅ:");
        return scanner.nextInt();
    }

    public String getPassword() {
        System.out.print("Password ์๋ ฅ:");
        return scanner.next();
    }

    public String getId() {
        System.out.print("ID ์๋ ฅ:");
        return scanner.next();
    }


    public int getLoginOrExit() {
        System.out.println("1. ์ง์ ๋ก๊ทธ์ธ ํ๊ธฐ");
        System.out.println("0. ๋ค๋ก๊ฐ๊ธฐ");
        return scanner.nextInt();
    }

    public void printLine() {
        System.out.println(END_LINE);
    }
}
