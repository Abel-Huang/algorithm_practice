package cn.abelib.algorithm;

import cn.abelib.common.RandomData;
import cn.abelib.common.StdIO;
import cn.abelib.common.Timer;
import cn.abelib.common.data.ConstantData;
import cn.abelib.common.data.EnumSort;
import cn.abelib.common.data.EnumType;
import cn.abelib.utils.sort.BasicSort;
import cn.abelib.utils.sort.InsertionSort;
import cn.abelib.utils.sort.SelectionSort;
import cn.abelib.utils.sort.merge.MergeSortBT;
import cn.abelib.utils.sort.merge.MergeSortTB;
import cn.abelib.utils.sort.priority.heap.HeapSort;
import cn.abelib.utils.sort.quick.MoreQuickSort;
import cn.abelib.utils.sort.quick.QuickSort;
import cn.abelib.utils.sort.ShellSort;

/**
 * Created by abel-huang on 2017/7/19.
 */
public class ResultTest{
    /**
     * @param obj
     */
    private void testInfo(Object obj){
        StdIO.println("Test class: "+obj.getClass().getSimpleName());
    }

    /**
     * @param range
     * @param size the size of array
     * @param et   the type of data
     * @param es   the class of sort
     */
    public void testSort(int range, int size, EnumType et, EnumSort es) throws TestException{
        Comparable [] a;
        switch (et){
            case INTEGER_TYPE:
                a = RandomData.randIntegerArray(range, size);
                break;
            case DOUBLE_TYPE:
                a = RandomData.randDoubleArray(range, size);
                break;
            case STRING_TYPE:
                a = RandomData.randStrArray(range, size);
                break;
            case CHARACTER_TYPE:
                a = RandomData.randCharArray(range, size);
                break;
            default:
                a = null;
        }
        if (a == null)
            return;
        BasicSort sort;
        switch (es){
            case INSERT_SORT:
                sort=new InsertionSort();
                break;
            case SELECTION_SORT:
                sort=new SelectionSort();
                break;
            case SHELL_SORT:
                sort=new ShellSort();
                break;
            case MERGE_SORT_1:
                sort=new MergeSortBT();
                break;
            case MERGE_SORT_2:
                sort=new MergeSortTB();
                break;
            case QUICK_SORT_1:
                sort=new QuickSort();
                break;
            case QUICK_SORT_2:
                sort=new MoreQuickSort();
                break;
            case HEAP_SORT:
                sort=new HeapSort();
                break;
            default:
                sort=null;
                break;

        }
        if(sort == null){
            return;
        }
        testInfo(sort);
        Timer timer = new Timer();
        sort.sort(a);
        StdIO.println("Runtime: " + timer.timeGoesBy());
        if(sort.isSorted(a))
            sort.show(a);
        else
            throw new TestException(ConstantData.SORT_ERROR_MSG);
    }

    private void testUtil(){

    }

    private void testSearch(){

    }
}