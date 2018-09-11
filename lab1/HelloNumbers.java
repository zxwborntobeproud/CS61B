public class HelloNumbers{
    public static void main(String[] args){
        int x = 0;
        int result = 0;
        while (x < 10){
            System.out.println(result);
            x += 1;
            result += x;
        }
    }
}