package com.techelevator.model;

import java.sql.Date;

public class Note {
	
	public String note;
	public int note_id;
	public int plot_id;
	public Date date;
	
	public Note(String note, int note_id, int plot_id) {
		this.note = note;
		this.note_id = note_id;
		this.plot_id = plot_id;
	}
	
	public Note(String note, int plot_id) {
		this.note = note;
		this.plot_id = plot_id;
	}
	
	public Note(int note_id, String note) {
		this.note = note;
		this.note_id = note_id;
	}
	
	public Note() {
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getPlot_id() {
		return plot_id;
	}
	public void setPlot_id(int plot_id) {
		this.plot_id = plot_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
