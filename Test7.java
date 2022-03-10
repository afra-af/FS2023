
import java.util.*;
import java.time.*;
import java.time.format.*;
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(str1,df);
        LocalDate date2 = LocalDate.parse(str2,df);
        System.out.print(Duration.between(date1.atStartOfDay(),date2.atStartOfDay()).toDays());
    }
}
