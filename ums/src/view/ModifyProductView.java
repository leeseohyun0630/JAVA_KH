package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class ModifyProductView {
	ModifyProductView(){
		ProductController controller = new ProductController();
		Scanner sc = new Scanner(System.in);
		ArrayList<ProductDTO> list = controller.getList(1,1);
		if(list == null) {
			System.out.println("등록된 상품이 없습니다.");
		}
		else {
			System.out.println("======== 내가 올린 상품 목록 ========");
			for(ProductDTO product : list) {
				System.out.printf("%d. %s : %d원 (재고 : %d개)\n", product.getProdnum(), product.getProdname(),
						product.getProdprice(), product.getProdamount());
			}
			System.out.println("================================");
		}
		
		System.out.print("수정할 상품 번호 : ");
		int prodnum = sc.nextInt();
		System.out.print("수정할 내용 선택 \n1. 이름\n2. 가격\n3. 수량\n4. 설명");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 내용 : ");
		String update = sc.nextLine();
		
		
		if(controller.modifyProduct(prodnum, choice, update)) {
			System.out.println(prodnum+"번 상품 수정 완료");
		}
		else {
			System.out.println("상품 수정 실패");
		}
	}
	
}
