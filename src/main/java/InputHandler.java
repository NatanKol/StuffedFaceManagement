import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    Scanner inputScanner = new Scanner(System.in);

    public String select_from_options_list(String... options) {
        //A list of options is provided as parameters. The user must choose one of those options, no other inputs are accepted.
        List<String> optionsList = Arrays.asList(options);
        String selection = "";
        boolean repeat = false;
        
        System.out.println("Select from the following options:");
        for(String option : optionsList) {
            System.out.println(option);
        }
        
        do{
            if(repeat){
                System.out.println("Invalid Selection. Try again. Ensure correct spelling");
            }

            try{
                selection = inputScanner.nextLine();
                selection = selection.toLowerCase();
            }
            catch (Exception e) {
                System.out.println("Invalid selection. Try again");
            }

            repeat = true;
        }while (!optionsList.contains(selection));
    return selection;
    }

    public String OpenEndedAlphaNumericInput(String message) {
        //Allows for any alphanumeric input
        String selection = "";

        System.out.println(message);

        try{
            selection = inputScanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("A problem occurred. Try again.");
        }



        return selection;
    }

    public int numericInput(String message) {
        //allows for any numeric input
        int selection = 0;
        boolean repeat = true;

        System.out.println(message);
        do {
            try{
                selection = inputScanner.nextInt();
                repeat = false;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again");
            }
            finally {
                inputScanner.nextLine();
            }
        } while (repeat);



        return selection;
    }

    public boolean booleanInput(String message, String correspondTrue, String correspondFalse) {
        //allows for a selection between boolean inputs. To avoid possibly ambiguous "true" or "false" input requests, the caller will provide two parameters that will correspond to true or false, which will be chosen by the user using the select from list method.
        System.out.println(message);
        String input = select_from_options_list(correspondTrue, correspondFalse);
        if(input.equals(correspondTrue)){ //I chose not to simplify despite the informational warning, as that would technically not be my code. Either way, I now know it is possible to simplify, which I was not aware of when writing this section.
            return true;
        }
        else {
            return false;
        }
    }
}
