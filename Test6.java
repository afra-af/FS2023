/*HDFC Credit card system generates bill on 1st day of a given month and gives 60 days period for repayment of the bill.
The manager of the bank wants to send an alert message to the customer every 'k' days ,  just to remind the bill payment. 
Kindly help the bank manager to send the customer a alert message every 'k' days of the bill start. 

The first line of input contains the date separated by the dd-MM-yyyy followed by the number of days 


input=01-05-2022
10
output= 
May 1, 2022 Bill Payment Due  on Thursday, June 30, 2022
May 11, 2022 Bill Payment Due  on Thursday, June 30, 2022
May 21, 2022 Bill Payment Due  on Thursday, June 30, 2022
May 31, 2022 Bill Payment Due  on Thursday, June 30, 2022
June 10, 2022 Bill Payment Due  on Thursday, June 30, 2022
June 20, 2022 Bill Payment Due  on Thursday, June 30, 2022


input=01-09-2021
15
output=
September 1, 2021 Bill Payment Due  on Sunday, October 31, 2021
September 16, 2021 Bill Payment Due  on Sunday, October 31, 2021
October 1, 2021 Bill Payment Due  on Sunday, October 31, 2021
October 16, 2021 Bill Payment Due  on Sunday, October 31, 2021 
*/

import java.util.*;
import java.time.*;
import java.time.format.*;
class Test{
    public static void sendAlerts(LocalDate start, LocalDate end, Period period){
        DateTimeFormatter lof = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter fuf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        while (start.isBefore(end)){
          System.out.println(lof.format(start)+" Bill Payment Due  on "+fuf.format(end));
          start = start.plus(period); 
        }  
    }
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start=LocalDate.parse(str,df);
        int n=sc.nextInt();
        Period period=Period.ofDays(n);
        LocalDate end=start.plusDays(60);
        //System.out.println(start+" "+end);
        sendAlerts(start,end,period);
    }
    
}
