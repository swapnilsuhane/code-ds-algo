package main.java.exercise.company.grab;

public class BusTicket {

    private static int findCheapestTicket(int[] ar){
        int ch = 0;
        int weeks=0;
        int days = 0;
        int monthlyCost = 25;
        for(int i=0; i <ar.length; i++){
            // System.out.println(i);
            int count=1;
            while(i <ar.length-1 && ar[i+1] == ar[i]+1){
                //System.out.println(ar[i] + " count: " +count);
                count++;
                i++;
                if(count==7){
                    break;
                }
            }
            System.out.println(" out count: " +count);
            if(count>3){
                weeks++;
            } else{
                days=days+count;
            }
        }
        System.out.println("no of weeks: "+weeks + " days: " +days);

        ch = weeks*7 + days*2;
        System.out.println("cost: "+ch);

        ch = Math.min(ch, monthlyCost);

        System.out.println("min cost: "+ch);

        return ch;
    }

    public static void main(String[] args) {
        int[] ar= {1,2,3,4,6,7,10,12,13,14,18,19,20,24,26,27,30};
        findCheapestTicket(ar);
    }

}
