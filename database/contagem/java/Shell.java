import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

class Student {

    public static int count(List<Integer> vet, int value) {
        int count = 0;
        for (Integer i: vet){
            if (i == value){
                count++;
            }
        }
        return count;
    }

    public static int sum(List<Integer> vet) {
        int sum = 0;
        for (Integer i: vet){
            if (i < 0){
                sum += i *= -1;
            }else{
                sum += i;
            }
        }
        return sum;
    }

    public static double average(List<Integer> vet) {
        double sum = 0;
        for (Integer i: vet){
            if (i < 0){
                sum += i *= -1;
            }else{
                sum += i;
            }
        }
        return sum / vet.size();
    }

    public static String moreMen(List<Integer> vet) {
        int men = 0;
        for (Integer i: vet){
            if (i > 0){
                men++;
            }
        }
        int women = vet.size() - men;
        if (women > men){
            return "women";
        }else if(women < men){
            return "men";
        }else{
            return "draw";
        }
    }

    public static String halfCompare(List<Integer> vet) {
        int meio = vet.size() / 2;
        int[] numeros = new int[2];

        for (int i = 0; i< vet.size(); i++){
            int valor = vet.get(i);
            if (valor < 0) valor *= -1;

            if (i < meio) {
                numeros[0] += valor;
            } else {
                numeros[1] += valor;
            }
        }
        if (numeros[0] > numeros[1]){
            return "first";
        }else if(numeros[0] < numeros[1]){
            return "second";
        }else{
            return "draw";
        }
    }

    public static String sexBattle(List<Integer> vet) {
        int men = 0;
        int women = 0;
        for (Integer i: vet){
            if (i < 0){
                women += i *= -1;
            }else{
                men += i;
            }
        }
         if (women > men){
            return "women";
        }else if(women < men){
            return "men";
        }else{
            return "draw";
        }
    }
}


public class Shell {
    public static void main(String[] _args) {
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            
            var args = line.split(" ");
            var cmd = args[0];
            
            if (cmd.equals("end")) {
                break;
            }
            else if (args[0].equals("count")) {
                int result = Student.count(strToVet(args[1]), Integer.parseInt(args[2]));
                System.out.println("" + result);
            }
            else if (args[0].equals("half_compare")) {
                String result = Student.halfCompare(strToVet(args[1]));
                System.out.println(result);
            }
            else if (args[0].equals("sex_battle")) {
                String result = Student.sexBattle(strToVet(args[1]));
                System.out.println(result);
            }
            else if (args[0].equals("sum")) {
                int result = Student.sum(strToVet(args[1]));
                System.out.println("" + result);
            }
            else if (args[0].equals("average")) {
                DecimalFormat df = new DecimalFormat("0.00");
                String result = df.format(Student.average(strToVet(args[1])));
                System.out.println(result);
            }
            else if (args[0].equals("more_men")) {
                String result = Student.moreMen(strToVet(args[1]));
                System.out.println(result);
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    public static List<Integer> strToVet(String s) {
        if (s.length() == 2) return new ArrayList<>();
        List<String> parts = Arrays.asList(s.substring(1, s.length() - 1).split(","));
        List<Integer> result = new ArrayList<>();
        for (String part : parts) {
            result.add(Integer.parseInt(part.trim()));
        }
        return result;
    }

    static Scanner scanner = new Scanner(System.in);
}
