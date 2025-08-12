import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Pair {
    Integer first;
    Integer second;

    Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
};
class Student {
    public static List<Pair> occurr(List<Integer> vet) {
        ArrayList<Pair> volta = new ArrayList<Pair>();
        for (int i = 0; i<vet.size(); i++){
            int value = Math.abs(vet.get(i));
            vet.set(i, value);
            if (!exists(volta, vet.get(i))){
                volta.add(new Pair(value, 1));
            }
        }
        sort(volta);
        return volta;
    }

    public static void sort(List<Pair> vet){
        Pair temp;
        for (int i = 0; i < vet.size() - 1; i++) {
            for (int j = i + 1; j < vet.size(); j++) {
                int absI = Math.abs(vet.get(i).first);
                int absJ = Math.abs(vet.get(j).first);

                if (absI > absJ) {
                    temp = new Pair(vet.get(i).first, vet.get(i).second);
                    vet.set(i, new Pair(vet.get(j).first, vet.get(j).second));
                    vet.set(j, temp);
                } 
            }
        }
    }

    public static boolean exists(List<Pair> vet, int value){
        if (vet.isEmpty()){
            return false;
        }
        for (Pair p : vet){
            if (p.first == value){
                p.second++;
                return true;
            }
        }
        return false;
    }

    public static void increment(List<Pair> vet, int first){
        if (vet.isEmpty()){
            vet.add(new Pair(first, 1));
            return;
        }

        Pair last = vet.get(vet.size() - 1);
        if (last.first.equals(first)) {
            last.second++;
        }else{
           vet.add(new Pair(first, 1)); 
        }
    }

    public static List<Pair> teams(List<Integer> vet) {
        ArrayList<Pair> volta = new ArrayList<>();
        for (int value : vet) {
            increment(volta, value);
        }
        return volta;
    }

    public static List<Integer> mnext(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for (Integer i : vet){
            volta.add(0);
        }
        for (int i = 1; i< vet.size()-1; i++){
            if (vet.get(i) < 0){
                if (vet.get(i-1) > 0) {volta.set(i-1, 1);}
                if (vet.get(i+1) > 0) {volta.set(i+1, 1);}
            }
        }
        return volta;
    }
    public static void muda(List<Integer> vet, int idx) {
        if(vet.get(idx) == 1){
            vet.set(idx, 0);
        }
    }
    public static List<Integer> alone(List<Integer> vet) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for (Integer i : vet){
            if(i < 0){
                volta.add(0);
                continue;
            }
            volta.add(1);
        }
        for (int i = 0; i < vet.size(); i++) {
            if (vet.get(i) < 0) {
                if (i > 0 && vet.get(i-1) > 0) {
                    muda(volta, i-1);
                }
                if (i < vet.size()-1 && vet.get(i+1) > 0) {
                    muda(volta, i+1);
                }
            }
        }
        return volta;
    }

    public static int couple(List<Integer> vet) {
        int esquerda = vet.remove(0);
        int casais = 0;
        while(!vet.isEmpty()){
            if (esquerda > 0 && vet.get(0) < 0){
                casais++;
                if (!vet.isEmpty()) {
                    vet.remove(0);
                }
                if (!vet.isEmpty()) {
                    esquerda = vet.remove(0);
                }
                continue;
            }
            if (esquerda < 0 && vet.get(0) > 0){
                casais++;
                if (!vet.isEmpty()) {
                    vet.remove(0);
                }
                if (!vet.isEmpty()) {
                    esquerda = vet.remove(0);
                }
                continue;
            }
            esquerda = vet.remove(0);
        }
        return casais;
    }

    public static boolean hasSubseq(List<Integer> vet, List<Integer> seq, int pos) {
        if (seq.size() > vet.size() - pos) {
            return false;
        }

        for( int i = 0; i < seq.size(); i++){
            if(!vet.get(i + pos).equals(seq.get(i))){
                return false;
            }
        }
        return true;
    }

    public static int subseq(List<Integer> vet, List<Integer> seq) {

        for(int i = 0; i < vet.size(); i++){
            if(vet.get(i) == seq.get(0)){
                if(hasSubseq(vet, seq, i)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static List<Integer> erase(List<Integer> vet, List<Integer> pos_list) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for(Integer idx : pos_list){
            vet.set(idx, 99);
        }
        for(Integer v : vet){
            if (!v.equals(99)){
                volta.add(v);
            }
        }
        return volta;
    }

    public static List<Integer> clear(List<Integer> vet, int value) {
        ArrayList<Integer> volta = new ArrayList<Integer>();
        for(int i = 0; i < vet.size(); i++){
            if (vet.get(i) != value){
                volta.add(vet.get(i));
            }
        }
        return volta;
    }
}

public class Shell {
    public static void main(String[] _args) {
        while (true) {
            var line = scanner.nextLine();
            var args = line.split(" ");
            System.out.println('$' + line);

            if (args[0].equals("end")) {
                break;
            }
            else if (args[0].equals("occurr")) {
                var array = strToVet(args[1]);
                System.out.println("" + Student.occurr(array));
            }
            else if (args[0].equals("teams")) {
                var array = strToVet(args[1]);
                System.out.println("" + Student.teams(array));
            }
            else if (args[0].equals("mnext")) {
                var array = strToVet(args[1]);
                System.out.println("" + Student.mnext(array));
            }
            else if (args[0].equals("alone")) {
                var array = strToVet(args[1]);
                System.out.println("" + Student.alone(array));
            }
            else if (args[0].equals("erase")) {
                var array = strToVet(args[1]);
                var positions = strToVet(args[2]);
                System.out.println("" + Student.erase(array, positions));
            }
            else if (args[0].equals("clear")) {
                var array = strToVet(args[1]);
                var value = Integer.parseInt(args[2]);
                System.out.println("" + Student.clear(array, value));
            }
            else if (args[0].equals("subseq")) {
                var array = strToVet(args[1]);
                var seq = strToVet(args[2]);
                System.out.println("" + Student.subseq(array, seq));
            }
            else if (args[0].equals("couple")) {
                var array = strToVet(args[1]);
                System.out.println("" + Student.couple(array));
            }
            else {
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
