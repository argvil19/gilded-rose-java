package com.gildedrose;

import com.gildedrose.ItemTypes.AgedBrie;
import com.gildedrose.ItemTypes.ConcertTicket;
import com.gildedrose.ItemTypes.EnrichedItem;
import com.gildedrose.ItemTypes.Sulfuras;

public class ItemFactory {
  public static Item createItem(Item item) {
    switch (item.name) {
      case AgedBrie.itemName:
        return new AgedBrie(item);
      case ConcertTicket.itemName:
        return new ConcertTicket(item);
      case Sulfuras.itemName:
        return new Sulfuras(item);
      default:
        return new EnrichedItem(item.name, item.sellIn, item.quality);
    }
  }
}
