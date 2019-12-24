package model;

import java.io.Serializable;

public class Yoine implements Serializable {
	private int yoineCount = 0;

	public void setYoineCount(int yoineCount) {
		this.yoineCount = yoineCount;
		System.out.println(this.yoineCount);
	}

	public int getYoineCount() {
		return yoineCount;
	}
}