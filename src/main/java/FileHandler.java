import java.io.*;

public class FileHandler {
    public void SerializeObject(MenuHandler menu, String filename) {
        //Serializes the specified object into the file specified. Code adapted from https://www.geeksforgeeks.org/serialization-in-java/
        try{
            FileOutputStream fileOutput = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);

            out.writeObject(menu);

            out.close();
            fileOutput.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong" + e);
        }
    }

    public MenuHandler DeserializeObject(String filename){
        // deserializes the object stored in the specified file, after ensuring the file exists. If an object is deserialized, it is returned. Code adapted from https://www.geeksforgeeks.org/serialization-in-java/
        File f = new File(filename);
        if (f.exists()) {
            MenuHandler menu = null;
            try{
                FileInputStream fileInput = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileInput);

                menu = (MenuHandler)in.readObject();

                in.close();
                fileInput.close();
            }
            catch (Exception e) {
                System.out.println("Something went wrong" + e);
            }
            System.out.println("Data Loaded");
            return menu;

        }
        else {
            System.out.println("File does not exist. Add items to menu and save before trying to load data");
            return null;
        }

    }
}
