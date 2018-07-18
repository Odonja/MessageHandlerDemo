package org.anhu.demo;

public class Message {

	private int rfid;
	private int readerid;
	
	Message() {	
	}

	public Message(int rfid, int readerid) {
		this.rfid = rfid;
		this.readerid = readerid;
	}

	public int getRfid() {
		return rfid;
	}

	public void setRfid(int rfid) {
		this.rfid = rfid;
	}

	public int getReaderid() {
		return readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	@Override
	public String toString() {
		return "[RFid = " + rfid + ", readerid = " + readerid + "]";
	}
}
