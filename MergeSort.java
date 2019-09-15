
import javafx.concurrent.Task;


// developed by: baeldug
// extracted and adapted from: https://www.baeldung.com/java-merge-sort
public class MergeSort
{

  private int[] array_to_sort;

  public int[] getArray_to_sort()
  {
	return array_to_sort;
  }

  @Override
	protected int[] call()
  {

		return getArray_to_sort(); //merge-sort done

	}

  public MergeSort(int[] in_array)
    {
      this.array_to_sort = in_array.clone();

      mergeSort(array_to_sort, array_to_sort.length);
    }

  public static void mergeSort(int[] a, int n)
  {
	    if (n < 2)
      {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
	}

  public static void merge(int[] a, int[] l, int[] r, int left, int right)
  {

      int i = 0, j = 0, k = 0;
      while (i < left && j < right)
      {
          if (l[i] <= r[j])
          {
              a[k++] = l[i++];
          }
          else
          {
              a[k++] = r[j++];
          }
      }
      while (i < left)
      {
          a[k++] = l[i++];
      }
      while (j < right)
      {
          a[k++] = r[j++];
      }
  }




}
