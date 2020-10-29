import java.util.Calendar;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		crr[] crrs = new crr[n];
		for (int i = 0; i < crrs.length; i++) {
			int crrNum = i + 1;
			String crrName = sc.next();
			int crrBirthYear = Integer.parseInt(sc.next().replace("년", ""));
			String crrClass = sc.next();
		
			crrs[i] = new crr();

			if (crrClass.equals("의적")) {
				crrs[i] = new 의적();
			} else if (crrClass.equals("도적")) {
				crrs[i] = new 도적();
			}
			if (crrClass.equals("상인")) {
				crrs[i] = new 상인();
			}

			crrs[i].crrNum = crrNum;
			crrs[i].crrName = crrName;
			crrs[i].crrBirthYear = crrBirthYear;
			crrs[i].crrAge = crrs[i].getAge();
			
			
		}
		for (int i = 0; i < crrs.length; i++) {
			String stats = sc.next();
			String [] stat = stats.split(",");
			
			crrs[i].stR = Integer.parseInt(stat[0]);
			crrs[i].inT = Integer.parseInt(stat[1]);
			crrs[i].deX = Integer.parseInt(stat[2]);
			
		}
		sc.close();
		for (int i = 0; i < crrs.length; i++) {
			crrs[i].intro();
			crrs[i].attk();
			
		}
	}
}

class crr {
	int crrNum;
	String crrName;
	int crrBirthYear;
	int crrAge;
	String crrClass;
	int stR;
	int inT;
	int deX;
	wpn aWpn;

	void intro() {
		System.out.println("== 자기소개 시작 ==");
		System.out.printf("번호 : %d번%n", crrNum);
		System.out.printf("내이름은 %s%n", crrName);
		System.out.printf("%d년생, %d살이지...!(TMI..?)%n", crrBirthYear, crrAge);
		System.out.printf("%s(이)다!%n", crrClass);
		System.out.printf("(힘 %d / 지능 %d / 민첩 %d)%n", stR, inT, deX);
		System.out.println("== 자기소개 끝 ==");
	}

	int getAge() {
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		return thisYear - crrBirthYear;
	}
	void attk() {
		System.out.println("== 공격 시작 ==");
		aWpn.run(crrName, crrClass, stR, deX);
		System.out.println("== 공격 종료 ==");
	}
}

class 의적 extends crr {
	의적() {
		crrClass = "의적";
		aWpn = new 검();
	}
}

class 도적 extends crr {
	도적() {
		crrClass = "도적";
		aWpn = new 도끼();
	}
}

class 상인 extends crr {
	상인() {
		crrClass = "상인";
		aWpn = new 지팡이();
	}
}
class wpn{
	String wpnName;
	int wpnAtt;
	
	void run (String crrName, String crrClass, int stR, int deX) {
		System.out.printf("%s %s(이)가 %s(으)로 공격합니다.%n", crrClass, crrName, wpnName);
		System.out.printf("- 무기 공격력 : %d%n", wpnAtt);
		System.out.printf("- 데미지 : %d%n", wpnAtt*stR*deX);
	}
}
class 검 extends wpn {
	검(){
		wpnName = "검";
		wpnAtt = 10;
	}
}
class 도끼 extends wpn {
	도끼(){
		wpnName = "도끼";
		wpnAtt = 15;
	}
}
class 지팡이 extends wpn {
	지팡이(){
		wpnName = "지팡이";
		wpnAtt = 2;
	}
}