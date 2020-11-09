import bubble_sort.BubbleSort;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void testBubbleSortArraySorted() {

        int[] source = new int[]{7, 13, 99, 42, 27, 3, 64, 51, 33, 108};
        BubbleSort.sort(source);

        int[] except = new int[]{3, 7, 13, 27, 33, 42, 51, 64, 99, 108};
        assertThat(source, Matchers.is(except));
    }
}
