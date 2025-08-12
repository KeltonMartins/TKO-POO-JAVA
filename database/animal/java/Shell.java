import java.util.Scanner;

public class Shell {

    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")  ) { 
                break;
            }
            else if (cmd.equals("init") ) {
                var species = par[1];
                var noise = par[2];
                animal = new Animal(species, noise);
            } 
            else if (cmd.equals("show")) {
                System.out.println(animal);
            } 
            else if (cmd.equals("noise")) {
                System.out.println(animal.makeSound());
            } 
            else if (cmd.equals("grow") ) {
                var increment = Integer.parseInt(par[1]);
                animal.ageBy(increment);
            }
            else {
                System.out.println("fail: comando invalido\n");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
