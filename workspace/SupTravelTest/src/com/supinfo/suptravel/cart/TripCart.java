package com.supinfo.suptravel.cart;

import java.util.Vector;

public class TripCart {
	private Vector<Item> items;
	
	public Vector<Item> getItems() {
		return (Vector<Item>) items.clone();
	}

	public void setItems(Vector<Item> items) {
		this.items = items;
	}

	public TripCart() {
		items = new Vector<Item>();
	}  

    public void addItem(Item newItem)
    {
        items.addElement(newItem);
    }

    public void removeItem(int itemIndex)
    {
        items.removeElementAt(itemIndex);
    }
}
