package com.qbabor4.hibernate.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.qbabor4.hibernate.enums.BookAvability;
import com.qbabor4.hibernate.enums.BookQuality;

/**
 * Jakoś zrobić stringa z enuma opisy do kolumn jakos moze dodac
 * 
 * @author Jakub
 *
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "UUID", nullable = false, columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(name = "AVABILITY", nullable = false, length = 40)
	@Enumerated(EnumType.STRING)
	private BookAvability bookAvability;
	@Column(name = "TITLE", nullable = false, length = 40)
	private String title;
	@Column(name = "ISBN", nullable = false, length = 40)
	private String isbn;
	@ManyToOne(cascade = CascadeType.ALL)
	private Publisher publisher; // łączenie z publisherem (uuid publishera) (chyba wiele do jednego) // @Column(name = "PUBLISHER", length = 40) // nullable = false
//	@Column(name = "YEAR", nullable = false, length = 4)
//	private Integer year;
//	@Column(name = "EDITION", nullable = false, length = 40)
//	private String edition;
//	@Column(name = "SERIES")
//	private UUID series; // łaczenie z series (uuid series) nazwa serii (chyba wiele do jednego)
//	@Column(name = "DESCRIPTION", length = 40)
//	private String description;
//	@Column(name = "QUALITY", length = 20)
//	@Enumerated(EnumType.STRING)
//	private BookQuality quality;
//	@Column(name = "LOCATION") // nullable = false
//	private UUID location; // łączenie z biblioteką
//	@Column(name = "LOCATION_DEPT") // nullable = false
//	private UUID locationDept; // łączenie z departamentem lokacji
//	@Column(name = "SIGNATURE", nullable = false, length = 100)
//	private String signature;
//	@Column(name = "BOOK_COMMENT", length = 400)
//	private String bookComment;
//	@Column(name = "LANGUAGE", length = 40) // nullable = false
//	private UUID language;
//	@Column(name = "ORIGIN")
//	private UUID origin; // kraj pochodzenia

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BookAvability getBookAvability() {
		return bookAvability;
	}

	public void setBookAvability(BookAvability bookAvability) {
		this.bookAvability = bookAvability;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

//	public Integer getYear() {
//		return year;
//	}
//
//	public void setYear(Integer year) {
//		this.year = year;
//	}
//
//	public String getEdition() {
//		return edition;
//	}
//
//	public void setEdition(String edition) {
//		this.edition = edition;
//	}
//
//	public UUID getSeries() {
//		return series;
//	}
//
//	public void setSeries(UUID series) {
//		this.series = series;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getQuality() {
//		return quality;
//	}
//
//	public void setQuality(String quality) {
//		this.quality = quality;
//	}
//
//	public UUID getLocation() {
//		return location;
//	}
//
//	public void setLocation(UUID location) {
//		this.location = location;
//	}
//
//	public UUID getLocationDept() {
//		return locationDept;
//	}
//
//	public void setLocationDept(UUID locationDept) {
//		this.locationDept = locationDept;
//	}
//
//	public String getSignature() {
//		return signature;
//	}
//
//	public void setSignature(String signature) {
//		this.signature = signature;
//	}
//
//	public String getBookComment() {
//		return bookComment;
//	}
//
//	public void setBookComment(String bookComment) {
//		this.bookComment = bookComment;
//	}
//
//	public UUID getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(UUID language) {
//		this.language = language;
//	}
//
//	public UUID getOrigin() {
//		return origin;
//	}
//
//	public void setOrigin(UUID origin) {
//		this.origin = origin;
//	}

}
