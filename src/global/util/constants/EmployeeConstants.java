package global.util.constants;

public class EmployeeConstants extends CommonConstants{

    public static final String HOME_START = "\n\n----------------Home----------------";
    public static final String HOME_SALES_EMP ="1. 영업 활동 팀";
    public static final String HOME_SALES_EMP_ ="11. 상담 대기 신규 고객 명단 조회 \n12. 영업 교육 수강";
    public static final String HOME_SALES_EDU_EMP ="2. 영업 교육 팀";
    public static final String HOME_SALES_EDU_EMP_ ="21. 영업 교육 강의 자료 업로드 \n22. 강의 자료 리스트 출력 \n23. 수강 명단 체크";
    public static final String HOME_CONTRACT_GUIDE_EMP ="3. 사후 관리 팀";
    public static final String HOME_CONTRACT_GUIDE_EMP_ ="31. 보험 정보 안내 해당 고객 명단 조회";
    public static final String HOME_CONTRACT_MNG_EMP ="4. 계약 관리 팀";
    public static final String HOME_CONTRACT_MNG_EMP_ ="41. 보험 계약 관리  \n42. 미납 고객 조회";
    public static final String HOME_UW_EMP ="5. U/W 팀";
    public static final String HOME_UW_EMP_ ="51. 인수심사 수행";
    public static final String HOME_INSURANCE_DEV_EMP ="6. 상품 개발 팀";
    public static final String HOME_INSURANCE_DEV_EMP_ ="61. 보험 설계 시작";
    public static final String HOME_CUS_INFORMATION_EMP ="7. 고객 정보 팀";
    public static final String HOME_CUS_INFORMATION_EMP_ ="71. 고객 정보를 제공";
    public static final String HOME_MARKET_ANALYSIS_EMP ="8. 시장 분석 팀";
    public static final String HOME_MARKET_ANALYSIS_EMP_ ="81. 보험 시장 데이터를 제공";
    public static final String HOME_INCIDENT_EMP_MENU ="9. 손해 접수 팀";
    public static final String HOME_INCIDENT_EMP_MENU_ ="91. 사고 발생 접수";
    public static final String HOME_REWARD_EMP_MENU ="10. 보상 평가 팀";
    public static final String HOME_REWARD_EMP_MENU_ ="101. 보상금 심사";
    public static final String HOME_MENU_LAST ="0. "+LOGOUT;

    public static final String DEPT_SALES ="DP1";
    public static final String DEPT_UW ="DP2";
    public static final String DEPT_INSURANCE_DEV ="DP3";
    public static final String DEPT_EDU ="DP4";
    public static final String DEPT_CONTRACT_MNG ="DP5";
    public static final String DEPT_CONTRACT_GUIDE ="DP6";
    public static final String DEPT_CUSTOMER_INFO ="DP7";
    public static final String DEPT_MARKET_ANAL ="DP8";
    public static final String DEPT_INCIDENT_MNG ="DP9";
    public static final String DEPT_REWARD = "DP10";

    public static final String CUSTOMER_CUNSULT_LIST_START = "-----미 상담 고객 목록-----";
    public static final String EXPIRED_CUSTOMER_LIST_START = "-----보험 만기 고객 목록-----";
    public static final String DEFAULT_CUSTOMER_LIST_START = "-----미납 고객 목록-----";
    public static final String UNCHOICED_INCIDENT_LIST_START = "-----담당자 미배정 사건 목록-----";
    public static final String NEAR_CONTRACT_LIST_START = "-----기간 만료 임박 계약 리스트-----";
    public static final String NEAR_PAYDAY_CONTRACT_LIST_START = "-----납부일 만료 임박 고객 리스트-----";
    public static final String CUSTOMER_ANALYSIS_DATA_START = "-------------고객 분석 데이터--------------";
    public static final String MARKET_ANALYSIS_DATA_START = "-------------시장 분석 데이터--------------";
    public static final String DEVELOP_INSURANCE_START = "--------------보험 설계하기--------------";

    public static final String ASK_CONSULT_CUSTOMER = "상담을 진행하려는 고객의 번호를 입력해주세요.";
    public static final String ASK_CUSTOMER_TO_UW = "인수심사를 진행할 고객 아이디를 입력하세요.";
    public static final String ASK_CHOICED_INCIDENT = "담당하려는 사건의 번호를 입력해주세요.";
    public static final String ASK_RESULT_OF_CLAIM = "청구에 대한 결과를 입력해주세요.";
    public static final String ASK_LECTURE_NAME = "강의 이름을 입력하세요:";
    public static final String ASK_LECTURE_PDF_NAME = "강의 자료 이름을 입력하세요.";
    public static final String ASK_TO_GET_UW_CUSTOMER_LIST = "인수 심사 대상 고객 명단을 불러오시겠습니까?";
    public static final String ASK_MAIL_TO_NEAR_EXPIRATION_CUSTOMER = "해당 고객들에게 계약에 해당하는 고객들에게 기간 만료 임박 이메일을 보내시겠습니까?";

    public static final String NOTIFY_MENU_1 = "1. 계약기간 만료 임박 계약 리스트 출력하기";
    public static final String NOTIFY_MENU_2 = "2. 보험 납부 기간 만료 임박 계약 리스트 출력하기";

    public static final String YES_OR_NO_1 = "1. 예";
    public static final String YES_OR_NO_2 = "2. 아니요";

    public static final String EXAMINATION_1 = "1.승인  ";
    public static final String EXAMINATION_2 = "2.거부  ";
    public static final String EXAMINATION_3 = "3.보류  ";

    public static final String KIND_OF_INSURANCE_1= "1.생명보험  ";
    public static final String KIND_OF_INSURANCE_2 = "2.손해보험  ";

    public static final String SMOKE_CONDITION_START = "--- 보험 가입 흡연 조건 설정하기(입력하신 Grade 이상이 되어야 보험이 가능합니다.)---";
    public static final String SMOKE_CONDITION_A = "하루 기준 담배 3개비는 이하, 10개비 미만은    A";
    public static final String SMOKE_CONDITION_B = "하루 기준 담배 10개비는 이상, 20개비 이하는   B";
    public static final String SMOKE_CONDITION_C = "하루 기준 담배 20개비 이상은               C";

    public static final String ALCOHOL_CONDITION_START = "--- 보험 가입 음주 조건 설정하기(입력하신 Grade 이상이 되어야 보험이 가능합니다.)---";
    public static final String ALCOHOL_CONDITION_A = "일주일 기준 소주 0.5병 이하, 1병 미만  A";
    public static final String ALCOHOL_CONDITION_B = "일주일 기준 소주 1병 이하, 2병 미만    B";
    public static final String ALCOHOL_CONDITION_C = "일주일 기준 소주 2병 이상은           C";

    public static final String CANCER_CONDITION_START = "--- 보험 가입 암 질병 조건 설정하기(입력하신 Grade 이상이 되어야 보험이 가능합니다.)---";
    public static final String CANCER_CONDITION_A = "현재 암과 관련된 질병이 없다면     A";
    public static final String CANCER_CONDITION_B = "현재 암 1기에 해당한다면         B";
    public static final String CANCER_CONDITION_C = "현재 암 1기 이상과 투병중인 상태   C";

    public static final String REGISTRATION_LECTURE_SUCCESS = "강의 등록에 성공했습니다.";
    public static final String REGISTRATION_LECTURE_FAIL = "강의 등록에 실패했습니다.";

    public static final String REGISTRATION_INSURANCE_SUCCESS = "보험 등록이 성공적으로 완료되었습니다.";
    public static final String REGISTRATION_MNG_SUCCESS = "담당자 설정이 완료되었습니다.";

    public static final String CONSULT_COMPLETE = "상담 완료";
    public static final String CONSULT_START = "상담 진행";

    public static final String PHONE_NUMBER = " 전화번호: ";
    public static final String NUMBER = " 번호: ";
    public static final String NAME = " 이름: ";
    public static final String KIND_OF_JOB = " 직군: ";
    public static final String ADDRESS = " 주소: ";
    public static final String DETAIL_ADDRESS = " 상세주소: ";
    public static final String ZIPCODE = " 우편번호: ";
    public static final String KIND_OF_INSURANCE = " 관심 보험 종류: ";
    public static final String JOINED_INSURANCE_NAME = " 가입한 보험 이름: ";
    public static final String INSURANCE_STATUS = " 현재 보험 상태: ";
    public static final String CUSTOMER_ID = " 고객 ID: ";
    public static final String CUSTOMER = " 사용자: ";
    public static final String DATE = " 일시: ";
    public static final String INSURANCE_NAME = " 보험 이름: ";
    public static final String MONTHLY_INSURANCE_FEE = " 월 청구비: ";
    public static final String MAX_AGE = " 가입 최대 나이: ";
    public static final String MIN_AGE = " 가입 최소 나이: ";
    public static final String PERMISSION = "승인";
    public static final String NOT_ALLOWED = " 거부";
    public static final String UNDER_EXAMINATION = "보류";

    public static final String TERMINATE_EMPLOYEE_SYSTEM = "직원 시스템을 종료합니다.\n\n";
}
