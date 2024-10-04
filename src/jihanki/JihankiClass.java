package jihanki;

import java.util.Scanner;

public class JihankiClass {
	
	public static String name[] = {"コーラ", "オレンジジュース", "お茶", "ビール"};
	public static int price[] = {100, 150, 200, 300};
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("======================================");
			for (int i=0; i<name.length; i++) {
				System.out.println((i+1) + ": " + name[i] + "  " + price[i] + "円");
			}
			int choice = getChoice();
		
			int payment = getPayment();
		
			showResult(choice, payment);
		
			int answer = getAnswer();
			if(answer==0)
				break;
		}
	}
	
	public static int getChoice() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("商品を選び、番号を入力してください。");
			try {
				String drink01 = scan.next();
				int drink02 = Integer.parseInt(drink01);
				if(drink02<=0 || drink02>=5) {
					System.out.println("【エラー】入力できるのは「1〜4」です。");
					continue;
				} else {
					System.out.println(name[drink02-1] + "は" + price[drink02-1] + "円です。");
					return drink02;
				}
			} catch(Exception e) {
				System.out.println("半角数字で入力してください。");
			}
		}
	}
	
	public static int getPayment() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("お金を入力してください。");
			try {
				String money01 = scan.next();
				int money02 = Integer.parseInt(money01);
				if(money02<=-1 || money02>=10001) {
					System.out.println("【エラー】入力できるのは「0〜10000」です。");
					continue;
				} else {
					return money02;
				}
			} catch(Exception e) {
				System.out.println("半角数字で入力してください。");
			}
		}
	}
	
	public static void showResult(int choice, int payment) {
		if (price[choice-1] == payment) {
			System.out.println("商品は" + name[choice-1] + "です。");
			System.out.println("商品をお受け取りください。");
		} else if (price[choice-1] < payment) {
			System.out.println("商品は" + name[choice-1] + "です。");
			int change = payment - price[choice-1];
			System.out.println("おつりは" + change + "円です。");
			System.out.println("商品とおつりをお受け取りください。");
		} else {
			System.out.println("お金が足りません。");
		}
	}
	
	public static int getAnswer() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("続けて購入されますか？");
			System.out.println("はい「1」を入力、いいえ「0」を入力");
			try {
				String answer01 = scan.next();
				int answer02 = Integer.parseInt(answer01);
				if(answer02 != 0 && answer02 != 1) {
					System.out.println("【エラー】入力できるのは「0または1」です。");
					continue;
				} else if (answer02==0) {
					System.out.println("ご利用ありがとうございました。");
					System.out.println("またのご利用お待ちしております。");
					break;
				} else {
					return answer02;
				}
			} catch(Exception e) {
				System.out.println("半角数字で入力してください。");
			}
		}
		return 0;
	}
	
}
