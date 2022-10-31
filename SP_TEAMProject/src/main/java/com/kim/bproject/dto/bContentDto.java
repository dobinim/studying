package com.kim.bproject.dto;

public class bContentDto {
	private int bookId; 			// id
	private String bookTitle;		// å ����
	private String bookOriTitle;	// ����
	private String writer;
	private String bookType;		// �Ϲ��ڷ�/��Ƽ�̵��
	private String publisher;		// ���ǻ�
	private String form;			// �ʼ�, ũ��(����)
	private String isbn;			// isbn ��ȣ
	private String bookContent;		// ����
	private String bookWriter;		// �۰�/������ ����
	private String bookIndex;		// ����
	private String genre;			// �帣
	private String year;			// ���ǳ⵵

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
