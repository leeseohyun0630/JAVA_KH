package model;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Date;

public class Food implements Serializable{
	String name;
	int kcal;
	
	public Food() {}

	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		
		return String.format("이름 : %s / 칼로리 : %dkcal", this.name, this.kcal);
	}

	public void fileSave(String fileName) throws Exception{
		FileWriter fw = new FileWriter(fileName+".txt");
		
		OutputStream os = null;
		os = new FileOutputStream(fileName+".txt");
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(os);
		Food food = new Food("사과", 20);
		oos.writeObject(food.toString());
		oos.close();
		os.close();
	}
}
