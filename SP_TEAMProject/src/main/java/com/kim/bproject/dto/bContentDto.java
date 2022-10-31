package com.kim.bproject.dto;

public class bContentDto {
	private int bookId; 			// id
	private String bookTitle;		// 책 제목
	private String bookOriTitle;	// 원제
	private String writer;
	private String bookType;		// 일반자료/멀티미디어
	private String publisher;		// 출판사
	private String form;			// 쪽수, 크기(세로)
	private String isbn;			// isbn 번호
	private String bookContent;		// 서평
	private String bookWriter;		// 작가/번역가 포함
	private String bookIndex;		// 목차
	private String genre;			// 장르
	private String year;			// 출판년도

	public bContentDto() {
		super();
		
	}
	
	public bContentDto(int bookId, String bookTitle, String bookOriTitle, String writer, String bookType,
			String publisher, String form, String isbn, String bookContent, String bookWriter, String bookIndex,
			String genre, String year) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookOriTitle = bookOriTitle;
		this.writer = writer;
		this.bookType = bookType;
		this.publisher = publisher;
		this.form = form;
		this.isbn = isbn;
		this.bookContent = bookContent;
		this.bookWriter = bookWriter;
		this.bookIndex = bookIndex;
		this.genre = genre;
		this.year = year;
	}



	// getter, setter
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookOriTitle() {
		return bookOriTitle;
	}
	public void setBookOriTitle(String bookOriTitle) {
		this.bookOriTitle = bookOriTitle;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getBookType() {
		return bookType;
	}
	
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getForm() {
		return form;
	}
	
	public void setForm(String form) {
		this.form = form;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookContent() {
		return bookContent;
	}
	
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	
	public String getBookWriter() {
		return bookWriter;
	}
	
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookIndex() {
		return bookIndex;
	}
	
	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
