package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class Sulfuras extends EnrichedItem {
  public static final String itemName = "Sulfuras, Hand of Ragnaros";

  public Sulfuras(Item item) {
    super(Sulfuras.itemName, item.sellIn, 80);
  }

  @Override
  public void age() {}
}
