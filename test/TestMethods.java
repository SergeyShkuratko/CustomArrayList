import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMethods {
    CustomArrayList<String> arrayList;

    @Before
    public void init() {
        arrayList = new CustomArrayList<>();
    }

    @Test
    public void addElements() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        assertEquals(12, arrayList.getSize());
    }

    @Test
    public void addElementByIndex() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.addByIndex("2.5", 2);
        arrayList.addByIndex("2.5", 2);
        arrayList.addByIndex("2.5", 2);
        arrayList.addByIndex("2.5", 2);
        assertEquals(12, arrayList.getSize());
    }

    @Test
    public void getByIndex() {
        arrayList.addByIndex("-1", 0);
        arrayList.addByIndex("new 5", 5);
        assertEquals("-1", arrayList.getByIndex(0));
        assertEquals("new 5", arrayList.getByIndex(5));
    }

    @Test
    public void setByIndex() {
        arrayList.addByIndex("oldVal", 0);
        arrayList.setByIndex("newVal", 0);
        assertEquals("newVal", arrayList.getByIndex(0));
    }

    @Test
    public void contains() {
        arrayList.add("cont");
        assertTrue(arrayList.contains("cont"));
        assertFalse(arrayList.contains("cont777"));
    }

    @Test
    public void indexOf() {
        arrayList.addByIndex("indexOf", 5);
        assertEquals(5, arrayList.indexOf("indexOf"));
    }

    @Test
    public void lastIndexOf() {
        arrayList.addByIndex("lastIndexOf", 5);
        arrayList.addByIndex("lastIndexOf", 8);
        assertEquals(8, arrayList.lastIndexOf("lastIndexOf"));
    }

    @Test
    public void removeById() {
        arrayList.addByIndex("testRemove", 0);
        arrayList.addByIndex("testRemove1", 0);
        arrayList.addByIndex("testRemove2", 0);
        int sizeBefore = arrayList.getSize();
        arrayList.removeByIndex(2);
        int sizeAfter = arrayList.getSize();
        assertEquals(sizeBefore - 1, sizeAfter);
        assertFalse(arrayList.contains("testRemove"));
    }

    @Test
    public void removeElement() {
        arrayList.addByIndex("testRemove", 0);
        arrayList.addByIndex("testRemove1", 0);
        arrayList.addByIndex("testRemove2", 0);
        int sizeBefore = arrayList.getSize();
        arrayList.remove("testRemove1");
        int sizeAfter = arrayList.getSize();
        assertEquals(sizeBefore - 1, sizeAfter);
        assertFalse(arrayList.contains("testRemove1"));
    }
}
