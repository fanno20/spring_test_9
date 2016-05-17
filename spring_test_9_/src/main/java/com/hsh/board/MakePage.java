package com.hsh.board;

public class MakePage {

	private int start;
	private int last;
	private int startNum;
	private int lastNum;
	private int totalBlock;
	private int curBlock;
	
	public MakePage() {	}
	public MakePage(int curPage, int totalList){
		int perPage = 10;
		start = (curPage - 1) * perPage + 1;
		last = curPage * perPage;
		int totalPage = sum(totalList, perPage);
		totalBlock = sum(totalPage,perPage);
		curBlock = sum(curPage, perPage);
		startNum = (curBlock - 1) * perPage + 1;
		if(curBlock == totalBlock){
			lastNum = totalPage;
		}else{
			lastNum = curBlock * perPage;
		}
		System.out.println("totalB" + totalBlock);
		System.out.println();
		System.out.println("start : "+ start + " last : " + last);
		System.out.println("startNum : "+ startNum + " lastNum : " + lastNum);
	}
	
	private int sum(int num1, int num2){
		int num = 0;
		if(num1 % num2 == 0){
			num = num1 / num2;
		}else{
			num = num1 / num2 +1;
		}
		return num;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
}
