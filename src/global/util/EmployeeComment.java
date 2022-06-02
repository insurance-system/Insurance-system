package global.util;

import java.util.Scanner;

public class EmployeeComment {

    Scanner scanner;

    public EmployeeComment() {
        this.scanner = new Scanner(System.in);
    }

    public int home(){
        System.out.println("----------------Home----------------");
        System.out.println("1. 영업 활동 팀");
        System.out.println("11. 상담 대기 신규 고객 명단 조회  12. 영업 교육 수강");
        System.out.println("------------------------------------");
        System.out.println("2. 영업 교육 팀");
        System.out.println("21. 영업 교육 강의 업로드  22. 수강 명단 체크");
        System.out.println("------------------------------------");
        System.out.println("3. 사후 관리 팀");
        System.out.println("31. 보험 정보를 안내한다.");
        System.out.println("------------------------------------");
        System.out.println("4. 계약 관리 팀");
        System.out.println("41. 보험 계약 관리  42. 미납 고객 조회");
        System.out.println("------------------------------------");
        System.out.println("5. U/W 팀");
        System.out.println("51. 인수심사를 수행한다.");
        System.out.println("------------------------------------");
        System.out.println("6. 상품 개발 팀");
        System.out.println("61. 보험 설계 시작");
        System.out.println("------------------------------------");
        System.out.println("7. 고객 정보 팀");
        System.out.println("71. 고객 정보를 제공");
        System.out.println("------------------------------------");
        System.out.println("8. 시장 분석 팀");
        System.out.println("81. 보험 시장 데이터를 제공");
        return scanner.nextInt();
    }
}
