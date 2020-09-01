package sort;

import java.util.Arrays;

public class sort {
    public static int [] sortIntegers (int [] input){
        return SortNumber.sortIntegers(input);
    }

    public static String [] sortStrings (String [] input){
        return SortString.sortString(input);
    }
}

class SortNumber{
    static int [] sortIntegers(int [] input){
        Arrays.sort(input);
        return input;
    }
}

class SortString {
    static String [] sortString (String [] input){
        Arrays.sort(input);
        return input;
    }
}
