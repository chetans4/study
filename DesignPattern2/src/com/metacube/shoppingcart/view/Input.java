package com.metacube.shoppingcart.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.entity.User;
import com.metacube.shoppingcart.controller.ProductController;
import com.metacube.shoppingcart.controller.ShoppingCartController;
import com.metacube.shoppingcart.controller.UserController;

public class Input {
	static Scanner scan = new Scanner(System.in);
	@SuppressWarnings("rawtypes")
	UserController userController = new UserController();
	ProductController productController = new ProductController();
	ShoppingCartController shoppingCartController = new ShoppingCartController();
	public void takeInput(){
		do{
			int choice;
			System.out.println("***Menu***");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Update Product");
			System.out.println("4. Show Products");
			System.out.println("5. Add User");
			System.out.println("6. Delete User");
			System.out.println("7. Update User");
			System.out.println("8. Show Users");
			System.out.println("9. Shop");
			System.out.println("10. Exit");
			System.out.println("Enter ur choice");
			choice = scan.nextInt();
			
			switch(choice){
				case 1: System.out.println("Enter name and Price of new Product");
					String name = scan.next();
					double price = scan.nextDouble();
					Product product = new Product(name, price);
					productController.add(product);
					break;
				
				case 2: System.out.println("Enter Product Id");
						int id = scan.nextInt();
						productController.remove(id);
						break;
						
				case 3:
					System.out.println("Enter id of the product to be upated");
					id = scan.nextInt();
					System.out.println("Enter new name and Price of the Product to be updated");
					name = scan.next();
					price = scan.nextFloat();
					System.out.println(productController.update(id,name,price));
					break;
					
				case 4: 
					for(Object obj: productController.getAllProducts()){
						Product productObj = (Product)obj;
						System.out.println("Id= "+productObj.getId()+" name= "+productObj.getName()+" price= "+productObj.getPrice());
					}
					break;
					
				case 5: 
					System.out.println("Enter UserName and Password of new User");
					name = scan.next();
					String password = scan.next();
					User user = new User(name,password);
					System.out.println(userController.add(user));
					break;
				case 6: System.out.println("Enter User id");
					int uid = scan.nextInt();
					System.out.println(userController.remove(uid));
					break;
				case 7:
					System.out.println("Enter UserID of the user to be upated");
					uid = scan.nextInt();
					System.out.println("Enter new name and password of the user to be updated");
					name = scan.next();
					password = scan.next();
					System.out.println(userController.update(uid,name,password));
					break;
				case 8: 
					for(Object obj: userController.getAllUsers()){
						User s = (User)obj;
						System.out.println("UserId= "+s.getId()+" Username= "+s.getUserName()+" Password = "+s.getPassword());
					}
					break;
				case 9:
					System.out.println("Enter UserName");
					name = scan.next();
					if(shoppingCartController.checkUser(name)){
						shopping(name);
					} else {
						System.out.println("User id not found");
					}
					break;
				case 10:
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid option");
				}
		}while(true);
	}
	private void shopping(String uid) {
		int choice,quantity;
		int pid;
		String user=uid;
		ShoppingCart cart = new ShoppingCart();
		shoppingCartController.newCart(uid, cart);
		do{
			System.out.println("Your cart:");
			if(shoppingCartController.getList(user).size() > 0 ){
			displayCart(shoppingCartController.getList(user));
			System.out.println("\t\t\t\t\t\t\tTotal Price="+shoppingCartController.getTotPrice(uid));
			} else {
				System.out.println("No product");
			}
			System.out.println("1.Add product");
			System.out.println("2.Remove product");
			System.out.println("3.Checkout");
			choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter product id and quantity");
				pid = scan.nextInt();
				quantity = scan.nextInt();
				System.out.println(shoppingCartController.addToCart(user, pid, quantity));
				break;
			case 2:
				System.out.println("Enter product id to be removed");
				pid = scan.nextInt();
				System.out.println(shoppingCartController.removeFromCart(uid, pid));
				break;
			case 3:
				shoppingCartController.removeCart(uid);
				return;
			default:
				System.out.println("Enter valid choice");
			}
		} while(true);
		
		
	}
	private void displayCart(Map<Product, Integer> list) {
		int count = 0;
		System.out.println("SlNo.\t\tName\t\tPrice\t\tQuantity");
		for(Entry<Product, Integer> m : list.entrySet()){
			System.out.println((count++) + "\t\t" +m.getKey().getName()+ "\t\t" +m.getKey().getPrice()+ "\t\t" +m.getValue());
		}
		
	}
}
