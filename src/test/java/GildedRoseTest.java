import org.example.GildedRose;
import org.example.Item;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    String AGED_BRIE = "Aged Brie";
    String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    String SULFURAS = "Sulfuras, Hand of Ragnaros";
    String CONJURED = "Conjured";


    @Test
    public void testName() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems()[0].getName());
    }


    @Test
    public void testAgedBrie() {
        Item[] items = new Item[] {
                new Item(AGED_BRIE, 3, 2),
                new Item(AGED_BRIE, 12, 5),
                new Item(AGED_BRIE, 22, 50),
                new Item(AGED_BRIE, 11, 32),
                new Item(AGED_BRIE, 10, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(3, items[0].getQuality());
        assertEquals(2, items[0].getSellIn());
        assertEquals(6, items[1].getQuality());
        assertEquals(11, items[1].getSellIn());
        assertEquals(50, items[2].getQuality());
        assertEquals(21, items[2].getSellIn());
        assertEquals(33, items[3].getQuality());
        assertEquals(10, items[3].getSellIn());
        assertEquals(2, items[4].getQuality());
        assertEquals(9, items[4].getSellIn());
    }

    @Test
    public void testBackstage() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE, 3, 2),
                new Item(BACKSTAGE, 12, 5),
                new Item(BACKSTAGE, 22, 50),
                new Item(BACKSTAGE, 11, 32),
                new Item(BACKSTAGE, 10, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(5, items[0].getQuality());
        assertEquals(2, items[0].getSellIn());
        assertEquals(6, items[1].getQuality());
        assertEquals(11, items[1].getSellIn());
        assertEquals(50, items[2].getQuality());
        assertEquals(21, items[2].getSellIn());
        assertEquals(33, items[3].getQuality());
        assertEquals(10, items[3].getSellIn());
        assertEquals(3, items[4].getQuality());
        assertEquals(9, items[4].getSellIn());
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] {
                new Item(SULFURAS, 0, 80),
                new Item(SULFURAS, -1, 80)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(80, items[0].getQuality());
        assertEquals(0, items[0].getSellIn());
        assertEquals(80, items[1].getQuality());
        assertEquals(-1, items[1].getSellIn());
    }

    @Test
    public void testConjured() {
        Item[] items = new Item[] {
                new Item(CONJURED, 3, 2),
                new Item(CONJURED, 12, 5),
                new Item(CONJURED, 22, 50),
                new Item(CONJURED, 11, 32),
                new Item(CONJURED, 10, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(1, items[0].getQuality());
        assertEquals(2, items[0].getSellIn());
        assertEquals(4, items[1].getQuality());
        assertEquals(11, items[1].getSellIn());
        assertEquals(49, items[2].getQuality());
        assertEquals(21, items[2].getSellIn());
        assertEquals(31, items[3].getQuality());
        assertEquals(10, items[3].getSellIn());
        assertEquals(0, items[4].getQuality());
        assertEquals(9 , items[4].getSellIn());
    }

    @Test
    public void testConjuredAndSulfuras() {
        Item[] items = new Item[] {
                new Item(CONJURED, 3, 2),
                new Item(CONJURED, 12, 5),
                new Item(CONJURED, 22, 50),
                new Item(CONJURED, 11, 32),
                new Item(CONJURED, 10, 1),
                new Item(SULFURAS, 0, 80),
                new Item(SULFURAS, -1, 80)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(1, items[0].getQuality());
        assertEquals(2, items[0].getSellIn());
        assertEquals(4, items[1].getQuality());
        assertEquals(11, items[1].getSellIn());
        assertEquals(49, items[2].getQuality());
        assertEquals(21, items[2].getSellIn());
        assertEquals(31, items[3].getQuality());
        assertEquals(10, items[3].getSellIn());
        assertEquals(0, items[4].getQuality());
        assertEquals(9 , items[4].getSellIn());
        assertEquals(80, items[5].getQuality());
        assertEquals(0, items[5].getSellIn());
        assertEquals(80, items[6].getQuality());
        assertEquals(-1, items[6].getSellIn());
    }

    @Test
    public void testConjuredAndSulfurasAndBackstage() {
        Item[] items = new Item[] {
                new Item(CONJURED, 3, 2),
                new Item(CONJURED, 12, 5),
                new Item(CONJURED, 22, 50),
                new Item(CONJURED, 11, 32),
                new Item(CONJURED, 10, 1),
                new Item(SULFURAS, 0, 80),
                new Item(SULFURAS, -1, 80),
                new Item(BACKSTAGE, 3, 2),
                new Item(BACKSTAGE, 12, 5),
                new Item(BACKSTAGE, 22, 50),
                new Item(BACKSTAGE, 11, 32),
                new Item(BACKSTAGE, 10, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals(1, items[0].getQuality());
        assertEquals(2, items[0].getSellIn());
        assertEquals(4, items[1].getQuality());
        assertEquals(11, items[1].getSellIn());
        assertEquals(49, items[2].getQuality());
        assertEquals(21, items[2].getSellIn());
        assertEquals(31, items[3].getQuality());
        assertEquals(10, items[3].getSellIn());
        assertEquals(0, items[4].getQuality());
        assertEquals(9 , items[4].getSellIn());
        assertEquals(80, items[5].getQuality());
        assertEquals(0, items[5].getSellIn());
        assertEquals(80, items[6].getQuality());
        assertEquals(-1, items[6].getSellIn());
        assertEquals(5, items[7].getQuality());
        assertEquals(2, items[7].getSellIn());
        assertEquals(6, items[8].getQuality());
        assertEquals(11, items[8].getSellIn());
        assertEquals(50, items[9].getQuality());
        assertEquals(21, items[9].getSellIn());
        assertEquals(33, items[10].getQuality());
        assertEquals(10, items[10].getSellIn());
        assertEquals(3, items[11].getQuality());
        assertEquals(9, items[11].getSellIn());
    }
}
