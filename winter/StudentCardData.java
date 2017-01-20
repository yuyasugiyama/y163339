package winter_challenge;

import java.util.ArrayList;

public class StudentCardData {
	public static ArrayList<StudentCard> studentCardList_= new ArrayList<StudentCard>();
	public void AddCard(StudentCard card){
		int flag=0;
		for(int i=0;i<studentCardList_.size();i++){
			if(studentCardList_.get(i).getNum()==card.getNum()){
				flag=1;
			}
		}
		if(flag==0){
		studentCardList_.add(card);
		}
	}
	public void printData(){
		for(int i=0;i<studentCardList_.size();i++){
			studentCardList_.get(i).printCardData();
		}
	}
}
