package javacode01;
/**
 * 商品排序
 * @author mofeibai
 *
 */
public class Goods implements Comparable<Object>{
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public Goods() {
		
	}
	
	public Goods(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
	
	//按照商品比较大小的方式：按照价格从低到高排序，再按照产品名称从低到高排序
	@Override
	public int compareTo(Object o) {
		if(o instanceof Goods) {
			Goods goods = (Goods) o;
			if(this.price > goods.price) {
				return 1;
			}
			else if(this.price < goods.price){
				return -1;
			}else {
//				return 0;
				return this.name.compareTo(goods.name);
			}
		}
		throw new RuntimeException("数据类型不符合");
	}
	
	
	

	
}
