package Menu;

import java.util.Scanner;

public class ScannerInput {
    private Scanner scn;

    public ScannerInput() {
        this.scn = new Scanner(System.in);
    }

    public int getInt(){
            return this.scn.nextInt();
    }

    public String getString(){
        return this.scn.nextLine();
    }


    public void closeScn(){
        this.scn.close();
    }
}





