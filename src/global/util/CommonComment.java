package global.util;

import java.util.Scanner;

public class CommonComment {

    Scanner scanner;

    public CommonComment() {
        this.scanner = new Scanner(System.in);
    }

    public int initial(){
        System.out.println("-------------------아프시조 보험-------------------");
        System.out.println("1.보험사 고객 \n2.사원\n3.종료");
        System.out.print("번호 입력:");
        return scanner.nextInt();
    }

    public String getPassword() {
        System.out.print("Password 입력:");
        return scanner.next();
    }

    public String getId() {
        System.out.print("ID 입력:");
        return scanner.next();
    }



}
