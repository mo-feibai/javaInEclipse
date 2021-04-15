package javacode02;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
	String orderName;
	int orderId;
	T orderT;

	public Order() {

	}

	public Order(String orderName, int orderId, T orderT) {
		this.orderName = orderName;
		this.orderId = orderId;
		this.orderT = orderT;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public T getOrderT() {
		return orderT;
	}

	public void setOrderT(T orderT) {
		this.orderT = orderT;
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderId=" + orderId + ", orderT=" + orderT + "]";
	}

	// 泛型方法
	public <E> List<E> copyFromArrayToList(E[] arr) {
		ArrayList<E> list = new ArrayList<>();
		for (E ele : arr) {
			list.add(ele);
		}
		return list;

	}

}
