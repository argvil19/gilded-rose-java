package com.gildedrose;

import java.util.Arrays;
import com.gildedrose.ItemTypes.EnrichedItem;

class GildedRose {
    EnrichedItem[] items;

    public GildedRose(Item[] items) {
        this.items = Arrays.asList(items).stream().map(item -> ItemFactory.createItem(item))
                .toArray(EnrichedItem[]::new);
    }

    public void updateQuality() {
        for (EnrichedItem item : items) {
            item.age();
        }
    }

    private boolean isHandOfRagnaros(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isTicketConcert(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isItemImprovingOverTime(Item item) {
        return isAgedBrie(item) || isTicketConcert(item);
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
