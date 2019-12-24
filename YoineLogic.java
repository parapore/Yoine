package model;

public class YoineLogic {

	// 引数をYoineインスタンスにすれば、ここでnewしなくて済む
	// そうすると別クラスで	newしたインスタンスをここで扱える。
	public void yoinePlus(Yoine y) {
		int count = y.getYoineCount();
		count++;
		y.setYoineCount(count);
	}
}
