package org.agilar.csd.refactoring.gildedRose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	
	public GildedRose(){
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		  items.add(new Item("Aged Brie", 2, 0));
		  items.add(new Item("Elixir of the Mongoose", 5, 7));
		  items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		  items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		  items.add(new Item("Conjured Mana Cake", 3, 6));
		  updateQuality(items);
	}

	public List<Item> updateQuality(List<Item> items) {
		  for (int i = 0; i < items.size(); i++) {
			    if ("Aged Brie" != items.get(i).name && "Backstage passes to a TAFKAL80ETC concert" != items.get(i).name) {
			      //TODO: Improve this code.
			      if (items.get(i).quality > 0) {
			        if ("Sulfuras, Hand of Ragnaros" != items.get(i).name) {
			          items.get(i).quality = items.get(i).quality - 1;
			        }
			      }
			    } else {
			      if (items.get(i).quality < 50) {
			        items.get(i).quality = items.get(i).quality + 1;
			        if ("Aged Brie" == items.get(i).name) {
			            if (items.get(i).sellIn < 6) {
			              items.get(i).quality = items.get(i).quality + 1;
			            }
			        }
			        //Increases the Quality of the stinky cheese if its 11 days to due date.
			        if ("Aged Brie" == items.get(i).name) {
			            if (items.get(i).sellIn < 11) {
			              items.get(i).quality = items.get(i).quality + 1;
			            }
			        }
			        if ("Backstage passes to a TAFKAL80ETC concert" == items.get(i).name) {
			          if (items.get(i).sellIn < 11) {
			            // See revision number 2394 on SVN.
			            if (items.get(i).quality < 50) {
			              items.get(i).quality = items.get(i).quality + 1;
			            }
			          }
			          //Increases the Quality of Backstage Passes if the Quality is 6 or less.
			          if (items.get(i).sellIn < 6) {
			            if (items.get(i).quality < 50) {
			              items.get(i).quality = items.get(i).quality + 1;
			            }
			          }
			        }
			      }
			    }
			    if ("Sulfuras, Hand of Ragnaros" != items.get(i).name) {
			      items.get(i).sellIn = items.get(i).sellIn - 1;
			    }
			    if (items.get(i).sellIn < 0) {
			      if ("Aged Brie" != items.get(i).name) {
			        if ("Backstage passes to a TAFKAL80ETC concert" != items.get(i).name) {
			          if (items.get(i).quality > 0) {
			            if ("Sulfuras, Hand of Ragnaros" != items.get(i).name) {
			              items.get(i).quality = items.get(i).quality - 1;
			            }
			          }
			        } else {
			          //TODO: Fix this.
			          items.get(i).quality = items.get(i).quality - items.get(i).quality;
			        }
			      } else {
			        if (items.get(i).quality < 50) {
			          items.get(i).quality = items.get(i).quality + 1;
			        }
			        if ("Aged Brie" == items.get(i).name && items.get(i).sellIn <= 0)
			            items.get(i).quality = 0;
			      } // of for.
			    }
			    if ("Sulfuras, Hand of Ragnaros" != items.get(i).name)
			      if (items.get(i).quality > 50) items.get(i).quality = 50;
			  }
			  return items;
	}
}

/*
	};
*/