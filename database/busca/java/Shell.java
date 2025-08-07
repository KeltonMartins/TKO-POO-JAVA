import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    static boolean in(List<Integer> vet, int x) {
        for (Integer i: vet) {
            if (i == x){
                return true;
            }
        }
        return false;
    }

    static int indexOf(List<Integer> vet, int x) {
        for (int i = 0; i< vet.size(); i++){
            if (vet.get(i) == x){
                return i;
            }
        }
        return -1;
    }

    static int findIf(List<Integer> vet) {
        for (int i = 0; i< vet.size(); i++){
            if (vet.get(i) > 0){
                return i;
            }
        }
        return -1;
    }

    static int minElement(List<Integer> vet) {
        if (vet.isEmpty()){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i< vet.size(); i++){
            int value = vet.get(i);
            if (min > value){
                min = value;
                idx = i;
            }
        }
        return idx;
    }

    static int findMinIf(List<Integer> vet) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i< vet.size(); i++){
            if (vet.get(i) > 0 && vet.get(i) < min){
                min = vet.get(i);
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println("Rodando o arquivo do estudante");
    }
}


public class Shell {
    public static void main(String[] _args) {
        while (true) {
            String line = scanner.nextLine();
            System.out.println('$' + line);

            var par = line.split(" ");
            var cmd = par[0];

            if ("end".equals(cmd)) {
                break;
            }
            else if ("in".equals(cmd)) {
                var array = strToVet(par[1]);
                var value = Integer.parseInt(par[2]);
                var result = Student.in(array, value); 
                System.out.println(result ? "true" : "false");
            }
            else if ("index_of".equals(cmd)) {
                var array = strToVet(par[1]);
                var value = Integer.parseInt(par[2]);
                var result = Student.indexOf(array, value);
                System.out.println("" + result);
            }
            else if ("find_if".equals(cmd)) {
                var result = Student.findIf(strToVet(par[1]));
                System.out.println("" + result);
            }
            else if ("min_element".equals(cmd)) {
                var result = Student.minElement(strToVet(par[1]));
                System.out.println("" + result);
            }
            else if ("find_min_if".equals(cmd)) {
                var result = Student.findMinIf(strToVet(par[1]));
                System.out.println("" + result);
            }
            else { 
                System.out.println("fail: comando invalido");
            }
        }
    }

    public static List<Integer> strToVet(String s) {
        if(s.length() == 2) return new ArrayList<>();
        List<String> parts = Arrays.asList(s.substring(1, s.length() - 1).split(","));
        List<Integer> result = new ArrayList<>();
        for (String part : parts)
            result.add(Integer.parseInt(part.trim()));
        return result;
    }

    static Scanner scanner = new Scanner(System.in);
}
