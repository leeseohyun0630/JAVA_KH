package view;

import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class AddProductView {
	public AddProductView() {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		
		System.out.print("상품 이름 : ");
		String prodname = sc.nextLine();
		System.out.print("상품 가격 : ");
		String prodprice = sc.nextLine();
		System.out.print("상품 수량 : ");
		String prodamount = sc.nextLine();
		System.out.print("상품 설명 : ");
		String prodinfo = sc.nextLine();
		
		ProductDTO product = new ProductDTO(0,prodname,Integer.parseInt(prodprice),
				Integer.parseInt(prodamount),prodinfo,0,null);
		
		if(controller.addProduct(product)) {
			System.out.println(prodname + " 상품 추가 완료!");
		}
		else {
			System.out.println("상품 추가 실패 / 다음에 다시 시도해주세요~");
		}
		
	}
	
}










