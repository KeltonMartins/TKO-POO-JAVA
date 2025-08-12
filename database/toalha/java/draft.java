import java.util.Scanner;

public class draft {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        
        Towel toalha = null;
        
        while(true){
            String line = input();
            write("$ "+ line);
            String[] a = line.split(" ");

            switch(a[0]){
                case "init":
                    toalha = new Towel(a[1], a[2]);
                    break;
                case "secar":
                    toalha.wringOut();
                    break;
                case "dry":
                    toalha.dry(toInt(a[1]));
                    break;
                case "show":
                    toalha.show();
                    break;
                case "end":
                    return;
            }
        }
    } 

    public static String input(){
        return sc.nextLine();
    }
    public static void write(String s){
        System.out.println(s);
    }
    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}

