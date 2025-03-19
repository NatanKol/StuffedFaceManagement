

public class StuffedFaceJavaExercise {
    public static void main(String[] args) {
        //Object and Variable declarations
        InputHandler input = new InputHandler();
        MenuHandler menu = new MenuHandler();
        FileHandler file = new FileHandler();
        String filename = "menuObjectFile";
        boolean repeat = true;

        //Welcome Message
        System.out.println("\n\n\nWelcome to the Stuffed Face restaurant management application. Here you can add items to your menu, view the menu, or load an existing menu");

        //Begin loop. Continue until user selects an exit option.
        do {
            //Allows user to select one of the strings given as parameter and nothing else.
            String userChoice = input.select_from_options_list("add to menu", "view menu", "exit", "save and exit", "load existing menu");
            //switch based on user selection
            switch (userChoice) {
                case "add to menu":
                    System.out.println("Are you adding a food or beverage?");
                    String itemType = input.select_from_options_list("food", "beverage");

                    if (itemType.equals("food")) {
                        //allows for any alphanumeric input
                        String itemToAdd = input.OpenEndedAlphaNumericInput("What Item would you like to add?");
                        //allows for any numeric input
                        int price = input.numericInput("What is the price of the item?");
                        menu.AddItem(itemToAdd, price);
                        System.out.println("Successful!");
                    } else {
                        String itemToAdd = input.OpenEndedAlphaNumericInput("What Item would you like to add?");
                        int price = input.numericInput("What is the price of the item?");
                        //allows for any boolean input, first parameter will correspond to true, other will correspond to false.
                        boolean alcohol = input.booleanInput("Is this drink alcoholic?", "yes", "no");
                        menu.AddItem(itemToAdd, price, alcohol);
                        System.out.println("Successful!");
                    }
                    break;
                case "view menu":

                    System.out.println("Which menu would you like to view?");
                    String Selection = input.select_from_options_list("food", "drinks", "alcohol");

                    switch (Selection) {
                        case "food":
                            System.out.println(menu.menu);
                            break;
                        case "drinks":
                            System.out.println(menu.beveragesMenu);
                            break;
                        case "alcohol":
                            System.out.println(menu.alcoholBeveragesMenu);
                            break;
                    }
                    break;
                case "exit without saving":
                    repeat = false;
                    break;
                case "save and exit":
                    //serialize the object specified into the specified filename
                    file.SerializeObject(menu, filename);
                    repeat = false;
                    break;
                case "load existing menu":
                    //deserialize the object from specified filename into temporary object.
                    MenuHandler temp = file.DeserializeObject(filename);
                    //if temp is not null, assign the deserialized object to the object we work with.
                    if(temp != null){
                        menu = temp;
                    }
                    break;

            }
        } while(repeat);

        System.out.println("Time to Leave! GoodBye!");
    }
}
