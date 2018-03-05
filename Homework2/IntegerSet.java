/*-------------------INTEGER SET CLASS-------------------------*/
public class IntegerSet
{
    private int size = 101;
    private boolean [] array;
    
    public IntegerSet()
    {
        array = new boolean [size];
        for(int i = 0; i < size; i++)
        {
            array[i] = false;               // fill the array with each boolean set to false
        }                                   //(indicates new empty set)
    }
/*----------------------UNION FUNCTION-------------------------*/
    public IntegerSet union(IntegerSet iSet)
    {
        IntegerSet union = new IntegerSet();
        for(int i = 0; i < size; i++)
        {
            union.array[i] = iSet.array[i] || array[i];        //fill new union array by ORing the two sets together
        }
        for(int j = 0; j < size; j++)
        {
            if(iSet.array[j] || array[j])
            {
                union.array[j] = true;
            }
        }
        return union;
    }
/*------------------INTERSECTION FUNCTION-----------------------*/
    public IntegerSet intersection(IntegerSet iSet)
    {
        IntegerSet intersection = new IntegerSet();
        for(int i = 0; i < size; i++)
        {
            intersection.array[i] = iSet.array[i] && array[i];  //fill new intersection array by ANDing the two sets together
        }
        for(int j = 0; j < size; j++)
        {
            if(iSet.array[j] && array[j])
            {
                intersection.array[j] = true;
            }
        }
        return intersection;
    }
/*--------------------INSERT FUNCTION----------------------------*/
    public IntegerSet insertElement(int data)
    {
        IntegerSet insert = new IntegerSet();
        array[data] = true;                                     //indicates that the integer now exists in the set
        for(int i = 0; i < size; i++)
        {
            insert.array[i] = array[i];                         //copy array (with the updated set) to new array
        }
        return insert;
    }
/*--------------------DELETE FUNCTION----------------------------*/
    public IntegerSet deleteElement(int data)
    {
        IntegerSet delete = new IntegerSet();
        for(int i = 0; i < size; i++)
        {
            delete.array[i] = array[i];                         //copy arrays to allow for deletion of elements
            if(i == data)
            {
                delete.array[i] = false;                        //iterates through array until desired integer is reached,
            }                                                   //then sets that position to false (thereby removing the element)
        }
        return delete;
    }
/*----------------ISEQUALTO FUNCTION------------------------------*/
    public boolean isEqualTo(IntegerSet iSet)
    {
        for(int i = 0; i < size; i++)
        {
            if(array[i] != iSet.array[i])                       //check to see if every element is equal in each set
            {
                return false;
            }
        }
        return true;                                            //return false if one or more elements are different, true otherwise
    }
/*------------------TOSTRING FUNCTION-----------------------------*/
    public String toString()
    {
        boolean empty = true;
        String start = "";
        for(int i = 0; i < size; i++)
        {
            if(array[i])
            {
                start += i + " ";
                empty = false;                                  //outputs current set (if any number between 1 and 100 exists within)
            }
        }
        if(empty)
        {
            start += "---";                                     //outputs dashed lines for emtpy set;
        }
        return start;
    }

}
