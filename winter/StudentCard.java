package winter_challenge;

public class StudentCard {

	private String stdnum;
	private String stdname;
	private int Balance;
	private String days=null;
	public int getBal(){return Balance;}
	public void setBal(int bal){Balance = bal;}
	public String getNum(){return stdnum;}
	public void setNum(String num){stdnum = num;}
	public String getNam(){return stdname;}
	public void setNam(String name){stdname = name;}
	public void setDays(String str){days = str;}
	public String getDays(){return days;}
	public StudentCard(String num,String name,int Balan){
		this.stdnum=num;
		this.stdname=name;
		this.Balance=Balan;
	}
	public void printCardData(){
		System.out.printf("%s:%s:%d\n",stdnum,stdname,Balance);
	}
}
