import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		캐릭터[] 캐릭터들 = new 캐릭터[n];

		for (int i = 0; i < 캐릭터들.length; i++) {
			int 번호 = i + 1;
			String 이름 = sc.next();
			int 태어난해 = Integer.parseInt(sc.next().replace("년", ""));
			String 직업 = sc.next();

			캐릭터 a캐릭터 = null;

			if (직업.equals("의적")) {
				a캐릭터 = new 의적();
			} else if (직업.equals("도적")) {
				a캐릭터 = new 도적();
			} else if (직업.equals("상인")) {
				a캐릭터 = new 상인();
			}

			a캐릭터.번호 = 번호;
			a캐릭터.이름 = 이름;
			a캐릭터.태어난해 = 태어난해;

			캐릭터들[i] = a캐릭터;
		}
		sc.close();
		for (int i = 0; i < 캐릭터들.length; i++) {
			캐릭터들[i].자기소개();
		}
	}

}

class 캐릭터 {
	int 번호;
	String 이름;
	int 태어난해;
	String 직업;

	void 자기소개() {
		System.out.println("== 자기소개 시작 ==");
		System.out.printf("번호 : %d번%n", 번호);
		System.out.printf("이름 : %s%n", 이름);
		System.out.printf("태어난해 : %04d년%n", 태어난해);
		System.out.printf("나이 : %d%n", get나이());
		System.out.printf("직업 : %s%n", 직업);
		System.out.println("== 자기소개 끝 ==");
	}

	int get나이() {
		int 연도 = Calendar.getInstance().get(Calendar.YEAR);
		return 연도 - 태어난해;
	}

}

class 의적 extends 캐릭터 {
	의적() {
		직업 = "의적";
	}
}

class 도적 extends 캐릭터 {
	도적() {
		직업 = "도적";
	}
}

class 상인 extends 캐릭터 {
	상인() {
		직업 = "상인";
	}
}