package com.imooc.io.serialize;

import java.io.Serializable;

public class Student implements Serializable{
	private String stuno;
	private String stuname;
	//transient关键字默认情况下不被序列化
	private transient int stuage;  
	
	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getStuage() {
		return stuage;
	}
	public void setStuage(int stuage) {
		this.stuage = stuage;
	}
	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
				+ stuage + "]";
	}
	 private void writeObject(java.io.ObjectOutputStream s)
		        throws java.io.IOException{
		 s.defaultWriteObject();
		 s.writeInt(stuage);
	 }
	 private void readObject(java.io.ObjectInputStream s)
		        throws java.io.IOException, ClassNotFoundException{
		  s.defaultReadObject();
		  this.stuage = s.readInt();
	}
}
