package project1.product.table;

public class Product 
{
	
	int productid;
	String productName;
	double productPrice;
	public Product(int productid, String productName, double productPrice) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
