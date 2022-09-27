import java.util.*;

class StringCalculator {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    int add(String input) {
        List<String> delimiters = new ArrayList<>();
        String[] del_temp = {",", "\n"};

        delimiters.add(del_temp[0]);
        delimiters.add(del_temp[1]);

        if (Objects.equals(input, "")) return 0;

        else if (input.startsWith("//")) {
            if (Objects.equals("[", input.substring(2,3))) {
                for (int i = 0; i < input.length()-2; i++) {
                    if (Objects.equals(input.substring(i, i+3), "]\\n")) {
                        del_temp = input.substring(3, i).split("]\\Q[");
                        for (int j = 0; j < del_temp.length; j++) {
                            delimiters.add(del_temp[j]);
                        }
                        input = input.substring(i+3);
                    }
                }
            }
            else {
                for (int i = 0; i < input.length()-1; i++) {
                    if (Objects.equals(input.substring(i, i+2), "\\n")) {
                        delimiters.add(input.substring(2, i));
                        input = input.substring(i+2);
                    }
                }
            }
            Collections.sort(delimiters);
            Collections.reverse(delimiters);
        }

        System.out.println(input); //выпилить


        for (int i = 0; i < delimiters.size(); i++) {
            input = input.replaceAll("\\Q" + delimiters.get(i) + "\\E", "*");
        }

        if (input.contains("**")) throw new IllegalArgumentException("two delimiters in a row");

        int result = 0;
        String[] nums = input.split("\\Q*");
        List<String> negative_nums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (isNumeric(nums[i])) {
                if (Integer.parseInt(nums[i]) > 1000) continue;
                else if (Integer.parseInt(nums[i]) < 0) negative_nums.add(nums[i]);
                else result += Integer.parseInt(nums[i]);
            }
            else throw new IllegalArgumentException("wrong delimiter");
        }

        if (negative_nums.size()!=0) throw new IllegalArgumentException("negative nums: " + negative_nums);

        return result;

    }
}



class Main {
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        StringCalculator calc = new StringCalculator();
        System.out.println(calc.add(str));
    }
}