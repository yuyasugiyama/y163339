/*
 * 学籍番号163339　杉山裕哉
 * 冬季課題
 * 追加内容
 * 　学生証に入っている残高の払い戻し機能の追加
 * 　履歴の表示
 * 　学生証データリストを別クラスに新たに作成
 */

package winter_challenge;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainShopCharger {
	Calendar cal=Calendar.getInstance();
	private static ArrayList<HashMap<String,String>> Log;
	static StudentCardData data = new StudentCardData();
	public StudentCard insertStudentCard=null;
	public void insertStudentCard(StudentCard Card){
		insertStudentCard = Card;
		data.AddCard(Card);
	}
	public String readDate(){
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
		String days = String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day)+"/"+String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);
		return days;
	}
	public void chargeMoney(int charge){
		if(insertStudentCard!=null){
			String days = readDate();
			insertStudentCard.setBal(insertStudentCard.getBal()+charge);
			insertStudentCard.setDays(days);
			addLog();
		}else{
			System.out.printf("カードが挿入されていません\n");
		}
	}
	public void printAccountBalance(){
		System.out.printf("%s %s:%s現在の残高%d円\n",insertStudentCard.getDays(),insertStudentCard.getNum(),insertStudentCard.getNam(),insertStudentCard.getBal());
	}
	public void addLog(){
		if(Log.size()==5){
			Log.remove(0);
		}
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userid",insertStudentCard.getNam());
		map.put("date",insertStudentCard.getDays());
		map.put("bal",String.valueOf(insertStudentCard.getBal()));
		Log.add(map);
	}
	public void printaccesslog(){
		for(int i=0;i<Log.size();i++){
			System.out.printf("%d:%s\n",i,Log.get(i));
		}
	}
	public void cashRefund(){
		int M=0,FS=0,OS=0,FH=0,OH=0,FT=0,T=0,F=0,O=0;
		int cash=insertStudentCard.getBal();
		while(cash!=0){
			if(cash>=10000){
				M++;
				cash=cash-10000;
			}else if(cash>=5000){
				FS++;
				cash=cash-5000;
			}else if(cash>=1000){
				OS++;
				cash=cash-1000;
			}else if(cash>=500){
				FH++;
				cash=cash-500;
			}else if(cash>=100){
				OH++;
				cash=cash-100;
			}else if(cash>=50){
				FT++;
				cash=cash-50;
			}else if(cash>=10){
				T++;
				cash=cash-10;
			}else if(cash>=5){
				F++;
				cash=cash-5;
			}else if(cash>=1){
				O++;
				cash=cash-1;
			}
		}
		insertStudentCard.setBal(0);
		System.out.printf("1万円札:%d枚　5千円札:%d枚　千円札:%d枚　500円玉:%d枚　100円玉:%d枚　50円玉:%d枚　10円玉:%d枚　5円玉:%d枚　1円玉:%d枚\n",M,FS,OS,FH,OH,FT,T,F,O);
		addLog();
	}

	public static void main(String[] arg){
		Log = new ArrayList<HashMap<String,String>>();
		StudentCard StudentCard1 = new StudentCard("B163339","Yuya Sugiyama",1000);
		StudentCard StudentCard2 = new StudentCard("B163421","Taro Tanaka",299);
		StudentCard StudentCard3 = new StudentCard("B163321","kazuki Ito",5499);
		MainShopCharger shop =new MainShopCharger();
		shop.insertStudentCard(StudentCard1);
		shop.chargeMoney(1000);
		shop.insertStudentCard(StudentCard2);
		shop.chargeMoney(3600);
		shop.insertStudentCard(StudentCard1);
		shop.cashRefund();
		shop.insertStudentCard(StudentCard3);
		shop.chargeMoney(3000);
		shop.insertStudentCard(StudentCard1);
		shop.chargeMoney(1000);
		shop.insertStudentCard(StudentCard2);
		shop.cashRefund();
		shop.printaccesslog();
		data.printData();
	}
}
