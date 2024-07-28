package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isItemImprovingOverTime(item)) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementQuality(item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    incrementQuality(item);

                    if (isTicketConcert(item)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                incrementQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                incrementQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isTicketConcert(item)) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        incrementQuality(item);
                    }
                }
            }
        }
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
