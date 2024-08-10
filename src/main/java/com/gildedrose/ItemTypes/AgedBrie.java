package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class AgedBrie extends EnrichedItem {
  public static final String itemName = "Aged Brie";

  public AgedBrie(Item item) {
    super(AgedBrie.itemName, item.sellIn, item.quality);
  }

  public void age() {
    if (this.quality < 50) {
      this.quality += 1;
    }
    this.sellIn -= 1;
  }
}
