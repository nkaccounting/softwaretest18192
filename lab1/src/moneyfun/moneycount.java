package moneyfun; 

public class moneycount {
//	int []havemoney={50,20,5,5,1,1,1};
	int []havemoney={1,1,2,3};
	int flag=1;
	public int minus(int m){
		if(m>=50){
			if(havemoney[0]==1){
				m=m-50;
				havemoney[0]=0;
				minus(m);
			}
			else{
				flag=0;
			}
		}
		else if(m>=20){
			if(havemoney[1]==1){
				m=m-20;
				havemoney[1]=0;
				minus(m);
			}
			else{
				flag=0;
			}
		}
		else if(m>=5){
			if(havemoney[2]>0){
				m=m-5;
				havemoney[2]=havemoney[2]-1;
				minus(m);
			}
			else{
				flag=0;
			}
		}
		else if(m>=1){
			if(havemoney[3]>0){
				m=m-1;
				havemoney[3]=havemoney[3]-1;
				minus(m);
			}
			else{
				flag=0;
			}
		}
		return flag;
	}
}
