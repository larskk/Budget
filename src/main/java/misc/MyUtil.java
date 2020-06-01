package misc;

public class MyUtil {
  public static int[] stringToIntegerArray(String[] stringArray) {
    int size = stringArray.length;
    int [] arr = new int [size];
    for(int i=0; i<size; i++) {
      arr[i] = Integer.parseInt(stringArray[i]);
    }
    return arr;
  }
}
