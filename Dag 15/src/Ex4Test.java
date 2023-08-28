import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ex4Test {
    public static void main(String[] args)
    {
        ArrayList<Integer> firstList = new ArrayList<>();
        firstList.addAll(List.of(10,1,2,4,5,6,10,9,12));
        ArrayList<Integer> switchedArrayList = switchingFirstLast(firstList);
        System.out.println("Switch ArrayList " + switchedArrayList.toString());
        ArrayList<Integer> zeroedEvenNumber = replaceAllEven(firstList);
        System.out.println("Alle even even is zeroed " + zeroedEvenNumber );
        System.out.println("Tjek for reference for første Array " + firstList.toString());
        System.out.println("Anden største tal " + secondHighest(firstList));

//        Collections.sort(firstList);

        System.out.println(firstList.size() - 1);

        if(isArrayListSorted(firstList))
        {
            System.out.println("Den er sorted ");
        }else {
            System.out.println("Den er ikke sorted ");
        }
        System.out.println("Tjek " + firstList.toString());

        ArrayList<Integer> shiftToTheRight = shiftToRight(firstList);
        System.out.println("Skiftet til højre " + shiftToTheRight.toString());

        if(isThereDoublets(firstList))
        {
            System.out.println("Der er doublets ");
        }else
        {
            System.out.println("Der ikke doublets ");
        }
        System.out.println(firstList.toString());

        System.out.println(firstList.size());

    }




    public static ArrayList<Integer> switchingFirstLast(ArrayList<Integer> listArray)
    {
        int temp = 0;
        temp = listArray.get(0);
        listArray.set(0,listArray.get(listArray.size()-1));
        listArray.set(listArray.size()-1,temp);
        return listArray;
    }



    public static ArrayList<Integer> replaceAllEven(ArrayList<Integer> listArray )
    {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < listArray.size(); i++ )
        {
          if(listArray.get(i) % 2 == 0)
          {
              temp.add(i,0);
          }else
          {
              temp.add(i,listArray.get(i));
          }
        }

        return temp;
    }

    public static int secondHighest(ArrayList<Integer> listArray)
    {
        int max = Collections.max(listArray);
        ArrayList<Integer> tempArray = new ArrayList<>(listArray.size());
        //for(int i = 0; i < listArray.size(); i++)
        //{
            //tempArray.add(i,listArray.get(i));
        //}
        //Collections.sort(tempArray);
       // int andenStørste = tempArray.size() - 2;
        int secondMax = 0;
        for(int i = 0; i < listArray.size(); i++)
        {
            if(listArray.get(i)< max && listArray.get(i) > listArray.get(i-1))
            {
                secondMax = listArray.get(i);
            }
        }
        return secondMax;
    }

    public static boolean isArrayListSorted(ArrayList<Integer> listArray)
    {
        boolean erDen = false;
        int temp = listArray.get(0);
        for(int i = 0; i < listArray.size() ; i ++)
        {
            if(listArray.get(i+1) >= listArray.get(i) && listArray.get(1) >= temp) {
                erDen = true;
            } else {
                return false;
            }
        }
        return erDen;
    }

    public static ArrayList<Integer> shiftToRight(ArrayList<Integer> listArray)
    {
        int temp = listArray.get(listArray.size() -1);
        ArrayList<Integer> tempArray = new ArrayList<>(listArray.size());
        for(int element : listArray)
        {
            tempArray.add(element);
        }
        for(int i = listArray.size() - 1; i >0; i--)
        {
            tempArray.set(i,listArray.get(i-1));
        }
        tempArray.set(0,temp);
        return tempArray;
    }
    public static boolean isThereDoublets(ArrayList<Integer> listArray)
    {
        boolean erDer = false;
        for(int i = 0; i < listArray.size(); i++) {
            for (int j = i+1; j < listArray.size(); j++) {
                if (listArray.get(i) == listArray.get(j)) {
                    erDer = true;
                }
            }
        }
        return erDer;
    }
}
