package org.buaa.DataCollect.database;

/**
 * the model of paper
 * @author jackland_lab
 *
 */
public class Paper {
	String id;
	String title;
	String author;
	String publisher;
	String cgname;
	String type;
	String paperAbstract;
	String reference;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCgname() {
		return cgname;
	}
	public void setCgname(String cgname) {
		this.cgname = cgname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPaperAbstract() {
		return paperAbstract;
	}
	public void setPaperAbstract(String paperAbstract) {
		this.paperAbstract = paperAbstract;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	
}
