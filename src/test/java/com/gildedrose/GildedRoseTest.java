package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDegradeNormalItemOverTime() {
        Item[] items = new Item[] {new Item("foo", 5, 50)};
        GildedRose app = new GildedRose(items);

        assertEquals(50, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(45, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        app.updateQuality();
        app.updateQuality();

        assertEquals(41, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void itemQualityCantBeNegative() {
        Item[] items = new Item[] {new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void agedBrieOrBackstageIncreasesQualityOverDays() {
        Item[] items = new Item[] {new Item("Aged Brie", 5, 5),
                new Item("Backstage passes to a TAFKAL80ETC concert", 40, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(10, app.items[0].quality);
        assertEquals(10, app.items[1].quality);

        assertEquals(0, app.items[0].sellIn);
        assertEquals(35, app.items[1].sellIn);
    }

    @Test
    void agedBrieOrBackstageQualityCantGoOverFifthy() {
        Item[] items = new Item[] {new Item("Aged Brie", 1, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);

        assertEquals(50, app.items[1].quality);
        assertEquals(1, app.items[1].sellIn);
    }

    @Test
    void backstagePassShouldUpdateQualityByTwoIfLessThanElevenDays() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void backstagePassShouldUpdateQualityByThreeIfLessThanSixDays() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void backstagePassQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(25, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void sulfurasDoesntChangeQuality() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 100; i++) {
            app.updateQuality();
        }

        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }


}
