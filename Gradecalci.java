import java.util.Scanner;
class Gradecalci{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        float avgpercent,total=0;
        int totalsub,i;
        System.out.println("enter number of subjects:");
        totalsub=sc.nextInt();
        for(i=1;i<=totalsub;i++){
            System.out.println("Marks obtained for subject-"+i+":");
            total+= sc.nextInt();
        }
        System.out.println("TOTAL MARKS : " + total);
        // Each subject is of 100 Marks
        avgpercent = (total / (totalsub * 100)) * 100;
        System.out.println("AVERAGE PERCENTAGE :"+avgpercent+"%");
        if(avgpercent>=90.0){
            System.out.print("Grade A");
        }
        else if(avgpercent>=75.0){
            System.out.print("Grade B");
        }
        else if(avgpercent>=65.0){
            System.out.print("Grade C");
        }
        else if(avgpercent>=55.0){
            System.out.println("Grade D");
        }
        else{
            System.out.println("Grade F");
        }
    }    

}
