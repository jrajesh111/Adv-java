package project1.product.table;

import java.util.List;



public class ProductMain {

	public static void main(String[] args) 
	{
		ProductDAO productDAO=new ProductDAO();
		
//		int rowcount1 = productDAO.save(new Product(01, "rajesh", 105));
//		System.out.println("Data inserted sucessfully...."+" "+rowcount1);
//		
//		int rowcount2 = productDAO.save(new Product(02, "mahesh", 100));
//		System.out.println("Data inserted sucessfully...."+" "+rowcount2);
//		
//		int rowcount3 = productDAO.save(new Product(03, "rakesh", 100 ));
//		System.out.println("Data inserted sucessfully...."+" "+rowcount3);
//
//		int rowcount4 = productDAO.save(new Product(04,"chandu", 150 ));
//		System.out.println("Data inserted sucessfully...."+" "+rowcount4);
//		
		 							//reading the data from database
		
		//Product pro = productDAO.findById(01);
			//System.out.println(pro);
		
					//Delete by price
//			int result = productDAO.deleteByPrice(100);
//			if(result!=0) {
//				System.out.println("deletion sucessfully....");
//			}
//			else {
//				System.out.println("deletion Failed....");
//			}	
		
									//Delete By Id
//			int result = productDAO.deleteById(3);
//			if(result==1) {
//				System.out.println("data deletion sucessfully....");
//			}
//			else {
//				System.out.println("data deletion Failed....");
//			}
			
//		List<Product> pro=productDAO.findaAll();
//		for(Product x:pro) 
//			System.out.println(x);
			
		
		int count=ProductDAO.updatePrice(100,200);
		System.out.println(count);
		
		
	}
}
