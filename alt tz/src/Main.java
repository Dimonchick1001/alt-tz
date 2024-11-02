import java.util.Scanner;

public class Main {
    public String parts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите арефметическое выражение: ");
            String parts = scanner.nextLine();
            if (parts.equals("exit")) {
                System.out.println("программа завершена");
                break;
            }
            String result = calculator(parts);
        }
        scanner.close();
    }

    static String calculator(String input){
        String[] partobj = input.split( " ");
        int x = partobj.length;
        StringBuilder parts = new StringBuilder(input);
        char digit = parts.charAt(0);
        if(Character.isDigit(digit)){
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        if(parts.length() > 10){
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        String result = new String();
        for(int i = 0 ; i < partobj.length ; i++ ){
            if(partobj[i].charAt(0) == '-'){
                minus(parts);
            } else if (partobj[i].charAt(0) == '+') {
                plus(parts);
            } else if (partobj[i].charAt(0) == '/') {
                separation(parts);
            } else if (partobj[i].charAt(0) == '*') {
                multiplication(parts);
            }else {

            }
        }
      return parts.toString();
    }

    static String minus(StringBuilder input) {
        String[] parts = input.toString().split(" ");
        int x = 0;

        for (int i = 0 ; i < parts.length; i++){
            if (parts[i].toString().charAt(0) == '-'){
                i = parts.length;
            }else {
                x++;
            }
        }
        for(int i  = 1; i < x ; i++){
            parts[0] = parts[0] + " " + parts[i];

        }

        int c = parts.length;
        int v = x + 1;
        for(int i = v + 1; i < c ; i++){
            parts[v] = parts[v] + " " + parts[i];
        }
        String partr1 = parts[0].toString();
        StringBuilder delete = new StringBuilder(parts[v]);
        delete.deleteCharAt(0);
        delete.deleteCharAt(delete.length() - 1);
        String part2 = delete.toString();
        String result;
        result = partr1.replace(part2, "");
        if (result.length() > 40){
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        System.out.println(result);
        return result;
    }


    static String plus(StringBuilder input){
        String[] parts = input.toString().split(" ");
        int x = 0;

        for (int i = 0 ; i < parts.length; i++){
            if (parts[i].toString().charAt(0) == '+'){
                i = parts.length;
            }else {
                x++;
            }
        }
        for(int i  = 1; i < x ; i++){
            parts[0] = parts[0] + " " + parts[i];

        }

        int c = parts.length;
        int v = x + 1;
        for(int i = v + 1; i < c ; i++){
            parts[v] = parts[v] + " " + parts[i];
        }
        StringBuilder delete = new StringBuilder(parts[v]);
        delete.deleteCharAt(0);
        StringBuilder delete2 = new StringBuilder(parts[0]);
        int z = delete2.length();
        delete2.deleteCharAt(z - 1);
        String partr1 = delete2.toString();
        String part2 = delete.toString();
        String result;
        result = partr1 + part2;
        System.out.println(result);
        return result;
    }

    static String multiplication(StringBuilder input){
        String[] parts = input.toString().split(" ");
        int x = 0;
        for (int i = 0 ; i < parts.length; i++){
            if (parts[i].toString().charAt(0) == '*'){
                i = parts.length;
            }else {
                x++;
            }
        }
        for(int i  = 1; i < x ; i++){
            parts[0] = parts[0] + " " + parts[i];
        }
        int c  = Integer.parseInt(parts[x + 1]);
        if(c > 10){
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        StringBuilder separ = new StringBuilder(parts[0]);
        separ.deleteCharAt(0);
        separ.deleteCharAt(separ.length() - 1);
        StringBuilder delete = new StringBuilder(parts[0]);
        delete.deleteCharAt(delete.length() - 1);
        parts[0] = delete.toString();
        for(int i = 1; i < c ; i++){
            parts[0] = parts[0] + separ;
        }
        String result = new String();
        result = parts[0];
        if (result.length() > 40) {
            StringBuilder result1 = new StringBuilder(result);
            int v = result.length();
            for (int i = v; i > 40; i--) {
                v--;
                result1.deleteCharAt(v);
            }
            System.out.println(result1 + "...\"");
        }else
        System.out.println(result + "\"");

        return result;
    }


    static String separation(StringBuilder input){
        String[] parts = input.toString().split(" ");
        int x = 0;
        for (int i = 0 ; i < parts.length; i++){
            if (parts[i].toString().charAt(0) == '/'){
                i = parts.length;
            }else {
                x++;
            }
        }
        for(int i  = 1; i < x ; i++){
            parts[0] = parts[0] + " " + parts[i];
        }
        int c  = Integer.parseInt(parts[x + 1]);
        if(c > 10){
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        StringBuilder separ = new StringBuilder(parts[0]);
        separ.deleteCharAt(0);
        separ.deleteCharAt(separ.length() - 1);
        StringBuilder delete = new StringBuilder(parts[0]);
        delete.deleteCharAt(delete.length() - 1);
        delete.deleteCharAt(0);
        int z = delete.length();
        int v = z/c;
        for (int i = z; i > v ; i--  ){
            z = z - 1;
            delete.deleteCharAt(z);
        }
        parts[0] = delete.toString();
        String result ;
        result = parts[0];
        if (result.length() > 40) {
            throw new IllegalArgumentException("Некорректный ввод данных");
        }
        System.out.println("\"" + result + "\"");
        return result;
    }
}