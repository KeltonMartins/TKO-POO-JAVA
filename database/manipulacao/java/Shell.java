import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Shell {
    static List<Integer> get_men(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for (Integer i : vet){
            if (i > 0){
                volta.add(i);
            }
        }
        return volta;
    }

    static List<Integer> get_calm_women(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for (Integer i: vet){
            if (i < 0){
                int max = i *= -1;
                if(max < 10){
                    volta.add(i *= -1);
                }
            }
        }
        return volta;
    }

    static List<Integer> sort(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        Integer temp = 0;
        for (int i = 0; i< vet.size() - 1; i++){
            for (int j = i + 1; j< vet.size(); j++){
                if (vet.get(i) > vet.get(j)){
                    temp = vet.get(i);
                    vet.set(i, vet.get(j));
                    vet.set(j, temp);
                }
            }
        }
        return vet;
    }

    static List<Integer> sort_stress(List<Integer> vet) {
        Integer temp = 0;

        for (int i = 0; i < vet.size() - 1; i++) {
            for (int j = i + 1; j < vet.size(); j++) {

                int absI = Math.abs(vet.get(i));
                int absJ = Math.abs(vet.get(j));

                if (absI > absJ) {
                    temp = vet.get(i);
                    vet.set(i, vet.get(j));
                    vet.set(j, temp);
                }
            }
        }
        return vet;
    }



    static List<Integer> reverse(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();

        for (int i = vet.size()-1; i >= 0; i--){
            volta.add(vet.get(i));
        }
        return volta;
    }

    static boolean exists(List<Integer> vet, int value) {
        for (Integer i : vet){
            if (i == value){
                return true;
            }
        }
        return false;
    }

    static List<Integer> unique(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();

        for (Integer i : vet){
            if (exists(volta, i)){
                continue;
            }else{
                volta.add(i);
            }
        }
        return volta;
    }

    static List<Integer> repeated(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for (int i = 0; i < vet.size(); i++){
            int value = vet.remove(0);
            if (exists(vet, value)){
                volta.add(value);
            }
        }
        return sort(volta);
    }

    public static void main(String[] _args) {
        while (true) {
            var line = scanner.nextLine();
            var args = line.split(" ");
            var cmd = args[0];
            System.out.println("$" + line);

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("get_men")) {
                var array = strToVet(args[1]);
                System.out.println("" + get_men(array));
            } else if (cmd.equals("get_calm_women")) {
                var array = strToVet(args[1]);
                System.out.println("" + get_calm_women(array));
            } else if (cmd.equals("sort")) {
                var array = strToVet(args[1]);
                System.out.println("" + sort(array));
            } else if (cmd.equals("sort_stress")) {
                var array = strToVet(args[1]);
                System.out.println("" + sort_stress(array));
            } else if (cmd.equals("reverse")) {
                var array = strToVet(args[1]);
                var other = reverse(array);
                System.out.println("" + array);
                System.out.println("" + other);
            } else if (cmd.equals("exists")) {
                var array = strToVet(args[1]);
                var value = Integer.parseInt(args[2]);
                System.out.println("" + exists(array, value));
            } else if (cmd.equals("unique")) {
                var array = strToVet(args[1]);
                System.out.println("" + unique(array));
            } else if (cmd.equals("repeated")) {
                var array = strToVet(args[1]);
                System.out.println("" + repeated(array));
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static List<Integer> strToVet(String s) {
        if (s.equals("[]"))
            return new ArrayList<>();
        List<String> parts = Arrays.asList(s.substring(1, s.length() - 1).split(","));
        List<Integer> result = new ArrayList<>();
        for (String part : parts)
            result.add(Integer.parseInt(part.trim()));
        return result;
    }

    static Scanner scanner = new Scanner(System.in);
}
