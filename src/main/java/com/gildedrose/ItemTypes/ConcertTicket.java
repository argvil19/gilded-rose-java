package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class ConcertTicket extends EnrichedItem {
  public static final String itemName = "Backstage passes to a TAFKAL80ETC concert";

  public ConcertTicket(Item item) {
    super(ConcertTicket.itemName, item.sellIn, item.quality);
  }

  public void age() {
    int qualityChange = 1;

    if (this.sellIn <= 10) {
      qualityChange = 2;
    }

    if (this.sellIn <= 5) {
      qualityChange = 3;
    }

    if (this.sellIn > 0) {
      if (this.quality < 50) {
        if ((this.quality + qualityChange) > 50) {
          this.quality = 50;
        } else {
          this.quality += qualityChange;
        }
      }
    }

    if (this.sellIn <= 0) {
      this.quality = 0;
    }

    this.sellIn -= 1;
  }
}
