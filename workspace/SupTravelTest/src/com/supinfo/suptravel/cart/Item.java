package com.supinfo.suptravel.cart;

import com.supinfo.suptravel.bean.Trip;

public class Item {
	
	private Trip trip;
	private int quantity;
	
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
