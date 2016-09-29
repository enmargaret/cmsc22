import java.lang.*;

/*
Solution by: Ena Margarita O. Bojos 
*/

public class Date{
    private int year;
    private int month;
    private int day;

    Date(){
        day = 1;
        month = 1;
        year = 1000;
    }

    Date(int yr, int mon, int day){
		setYear(yr);
		setMonth(mon);
		setDay(day);
    }
    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public void setYear(int yr){
        if(yr<1000 || yr>9999){
            throw new IllegalArgumentException("Year is not valid.");
        }
        this.year = yr;
    }

    public void setMonth(int mon){
        if(mon<1 || mon>12){
            throw new IllegalArgumentException("Month is not valid.");
        }
        this.month = mon;
    }

    public void setDay(int day){
        if(month ==1 || month ==3 || month ==5 || month ==7 || month ==8 || month ==10 || month ==12){
            if(day<1 || day>31){
                throw new IllegalArgumentException("Day is not valid.");
            }
        }
        else if(month == 2){
            if((year%4==0 && year%100==0) && (day<1 || day>29)){
                throw new IllegalArgumentException("Day is not valid~~.");
            }
			else if(year%4==0){
				this.day = day;
			}
            else if(day<1 || day>28){
                throw new IllegalArgumentException("Day is not valid~.");
            }
        }
        else if (day<1 || day>30){
            throw new IllegalArgumentException("Day is not valid.");
        }
        this.day = day;
    }

    public String toString(){
        return String.format("%02d/%02d/%d",day,month,year);
    }

    public void setDate(int yr, int mon, int day){
        setYear(yr);
        setMonth(mon);
        setDay(day);
    }

}

