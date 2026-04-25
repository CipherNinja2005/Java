
public class div{
    public int num;

    public static void main(String[] args){

        div d = new div();

        for(int i=1; i<5; i++){
            d.num = i;
            if(d.num%2==0){
                System.out.println(d.num + " is divisible by 2");
            }
            if (d.num%3==0){
                System.out.println(d.num + " is divisible by 3");
            }
            if (d.num%5==0){
                System.out.println(d.num + " is divisible by 5");
            }
            else{
                System.out.println(d.num + " is not divisible by either 2,3 or 5");
            }
        }
    }
}