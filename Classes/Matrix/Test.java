public class.Solution{
public static void main(String[]args){
    Scanner scanner=new Scanner(System.in);
    for(int i=11111;i<99999;i++){
    String s=Integer.toString(i*4);
    StringBuilder stringBuilder=new StringBuilder(s);
    s=stringBuilder.reverse().toString();
    int x=Integer.valueOf(s);
    if(i==x){
    System.out.println(i);
    }
    }
    }
    }
