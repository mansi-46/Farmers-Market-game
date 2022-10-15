package week04;

import java.util.Scanner;

/**
 * Lecture 6 example of filling an array with information form the user, linear search and break;
 */
public class DalhousieAccess {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        String[] accessList = new String[4];
        for (int i = 0; i < accessList.length; i++) {
            accessList[i] = kb.nextLine();
        }

        String accessBanner = kb.nextLine();
        boolean isFound = false;
        for (int i = 0; i < accessList.length; i++) {
            if(accessBanner.equals(accessList[i])){
                isFound = true;
                break;
            }
        }
        //Example with foreach
//        for(String name : accessList){
//            if(name.equals(accessBanner)){
//                isFound = true;
//                break;
//            }
//        }

        if(isFound){
            System.out.println("Access Granted");
        }
        else {
            System.out.println("Access Denied");
        }

    }
}
