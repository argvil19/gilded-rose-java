package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class EnrichedItem extends Item {
  public EnrichedItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void age() {
    if (this.quality > 0) {
      this.quality -= 1;

      if (this.sellIn <= 0) {
        this.quality -= 1;
      }
    }

    this.sellIn -= 1;
  }
}
