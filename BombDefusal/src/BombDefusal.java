import java.util.Scanner;

public class BombDefusal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("========== 시한폭탄 해체 시뮬레이터 가동 ==========");

        //시리얼 번호: 전자기기나 제품 뒷면에 적혀 있는 '고유 일련번호'를 의미한다.

        // 1. 시리얼 번호 입력
        System.out.print("시리얼 번호 4자리를 입력하시오. (1000 ~ 9999): ");
        int serial = s.nextInt();

        // 2. 배터리 개수 입력
        System.out.print("부착된 배터리 개수 입력 (0 ~ 5): ");
        int battery = s.nextInt();

        // 3. 시간 선택 옵션
        System.out.println("타이머 난이도를 선택하세요. (1. 15초 / 2. 30초 / 3. 60초)");
        System.out.print("번호 선택(1~3): ");
        int timeChoice = s.nextInt();

        int time = 30; // 2번을 골랐을 때의 기본값 30초를 미리 깔아둔다.
        if (timeChoice == 1) time = 15; // 1번을 고르면 15초로 변경
        if (timeChoice == 3) time = 60; // 3번을 고르면 60초로 변경

        System.out.println(" 현재 남은 시간: [" + time + "초] ");

        // 4. 해체 매뉴얼 출력
        System.out.println("[ 폭탄 해체 매뉴얼 ]");
        System.out.println("빨간 선(1) : 시리얼 번호가 짝수이면서 배터리가 2개 이상일 때 절단하세요.");
        System.out.println("파란 선(2) : 시리얼 번호가 홀수이거나 배터리가 2개 미만일 때 절단하세요.");
        System.out.println("노란 선(3) : 건드리면 즉시 폭발하므로 절대 자르지 마세요.");

        System.out.print("\n매뉴얼에 따라 자를 선의 번호(1~3)를 선택하세요: ");
        int wire = s.nextInt();

        System.out.println("\n(선을 잘랐습니다...)\n");

        // 핵심 로직: 시리얼 번호 짝수 판별
        boolean isEven = (serial % 2 == 0);

        // 선택한 선에 따른 분기 처리
        switch (wire) {
            case 1: // 빨간 선
                if (isEven && battery >= 2) {
                    System.out.println("해체 성공! (" + time + "초 남기고 생존)");
                    System.out.println("당신은 도시를 구했습니다!");
                } else {
                    System.out.println("BOOM! 폭발!");
                    System.out.println("오답입니다. 매뉴얼의 조건을 충족하지 못했습니다.");
                }
                break;

            case 2: // 파란 선
                if (!isEven || battery < 2) {
                    System.out.println("해체 성공! (" + time + "초 남기고 생존)");
                    System.out.println("당신은 침착한 판단력으로 폭탄을 무력화했습니다!");
                } else {
                    System.out.println("BOOM! 폭발!");
                    System.out.println("잘못된 판단입니다. 폭탄이 터졌습니다!");
                }
                break;

            case 3: // 노란 선
                System.out.println("BOOM! 폭발!");
                System.out.println("건드리면 즉시 폭발하는 선이었습니다!");
                break;

            default: // 1, 2, 3 이외의 번호를 눌렀을 경우
                System.out.println("BOOM! 폭발!");
                System.out.println("당신은 없는 선을 건드렸습니다!");
                break;
        }

        s.close();
    }
}