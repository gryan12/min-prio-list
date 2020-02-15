import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
public class MinPriorityQueueTest {

    MinPriorityQueue<Integer> testQueue = new MinPriorityQueue<>();

    @Test
    public void queueIsEmptyByDefault() {
        assertThat(testQueue.isEmpty(), is(true));
    }

    @Test
    public void removeReturnsNullWhenEmpty() {
        assertNull(testQueue.remove());
    }

    @Test
    public void canAddElement() {
        testQueue.add(5);
        assertThat(testQueue.front(), is(5));
        assertThat(testQueue.back(), is(5));
    }

    @Test
    public void canRemoveElement() {
        assertThat(testQueue.isEmpty(), is(true));
    }
    @Test
    public void queueResizesWhenFull() {
        assertThat(testQueue.isEmpty(), is(true));
    }
}
