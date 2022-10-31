package com.kim.ex1601;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
@MultipartConfig(maxFileSize=1024*1024*5)
/* @MultipartConfig
 - form�� enctype�� multipart/form-data�� �� �̸� ó���ϴ� ������̼�
 - maxFileSize : �뷮 ���� / 1024*1024*5 �� 5MB              
 - maxRequestSize : request ��ü�� ���� �� �ִ� �ִ� ������. ���� default�� ����(-1). ���Ѵ�
 - location : ���� ��ġ (���� ���) 												*/
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "upload";
	} // home()�� ��
	
	@RequestMapping("/uploadSingle")
	public String uploadSingle(MultipartHttpServletRequest mtpRequest, Model model) {
		/* MultipartHttpServletRequest 
		 - enctype = "multipart/form-data" ó�� �� MultipartHttpServletRequest ��ü ���
		 - form�� �Ķ���� �� �� getParameter() �޼���� ��ȯ 								*/
		String src = mtpRequest.getParameter("src"); // ���ε��� ����� �̸� (input�� name �Ӽ�)
		System.out.println("���δ� : " + src);
		// form�� �ø� ������ getFile("name�Ӽ�")
		MultipartFile mf = mtpRequest.getFile("file");
		/* MultipartFile MultipartRequest.getFile(String name) 
		 - form���� �� ���� ��ü �� MultipartFile ��ü��!			*/
																		/* ���� ��� ǥ�� */
		String path1 = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String path2 = "C:\\KIMKIM\\apache-tomcat-9.0.63\\wtpwebapps\\SP_CH16EX01\\resources\\upimage\\";
		/* path1 : ������Ʈ�� ���� ��ġ 
		   path2 : �̶� tomcat���������� �ӽ÷� ������ �ڱ� ��ο� ������ �� tomcat���� ���� ��ġ 
		   ��Ŭ�������� ���� �� ������ �̹����� �ٷ� ������ �ʴ� ��찡 �־� tomcat�� ���� ���� (���� ���� �ÿ��� path2 �ʿ�X) */
		
		// form���� ���� ���� �̸� 
		String originalFileName = mf.getOriginalFilename();
		// ���� ������ ���� ������(long�� ����Ʈ ����)
		long fileSize = mf.getSize();
		System.out.println("originalFileName : " + originalFileName);
		System.out.println("fileSize : " + fileSize);
		// ���ε�� ���ϵ��� ������ �̸��� ���� ��찡 �����Ƿ� ������ �̸����� �����Ͽ� �����ؾ� �Ѵ�.
		// ���� �����ڷ� System.currentTimeMillis()�� ���ϸ� �տ� ����
		long pfix = System.currentTimeMillis();
		String safeFile1 = path1 + pfix + originalFileName;	// pfix + originalFileName �� ���ε�� ������ �̸��� ��
		String safeFile2 = path2 + pfix + originalFileName; 
		System.out.println("safeFile1 : " + safeFile1);
		System.out.println("safeFile2 : " + safeFile2);
		
		String dfile = pfix + originalFileName; // �ٿ�ε� �׽�Ʈ�� ���� �̸�
		try {
			/* MultipartFile�� transferTo(File dest)throws IOException, IllegalStateException �޼��� 
			  �� ���޹��� ��ü�� �Ķ������ ���� ��ü�� ���� 													*/
			mf.transferTo(new File(safeFile1)); // ������ �ش� ��ο� �ִ� ������ ���� ��ġ�� �̵����Ѷ�.
			mf.transferTo(new File(safeFile2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// �̵��� ������ download.jsp���� ����� �����Ͱ�
		model.addAttribute("author", src);
		model.addAttribute("fileName", dfile);
		model.addAttribute("fileSize", fileSize);
		
		return "download";
		
	} // uploadSingle()�� ��

	@RequestMapping("/uploadMulti")
	public String uploadMulti(MultipartHttpServletRequest mtpRequest, Model model) {
		List<MultipartFile> fileList = mtpRequest.getFiles("file");
		// List<MultipartFile> MultipartRequest.getFiles(String name)
		String src = mtpRequest.getParameter("src");
		System.out.println("�ø���� : " + src);
		
				/* ���� ��� ǥ�� */
		String path1 = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String path2 = "C:\\KIMKIM\\apache-tomcat-9.0.63\\wtpwebapps\\SP_CH16EX01\\resources\\upimage\\";
		
			/* ���ε��� ���� ������ŭ �ݺ� */
		for(MultipartFile mf : fileList) {
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			System.out.println("OriginalFileName : " + originalFileName);
			System.out.println("fileSize : " + fileSize);
			
			long pfix = System.currentTimeMillis();
			String safeFile1 = path1 + pfix + originalFileName;	// pfix + originalFileName �� ���ε�� ������ �̸��� ��
			String safeFile2 = path2 + pfix + originalFileName; 
			System.out.println("safeFile1 : " + safeFile1);
			System.out.println("safeFile2 : " + safeFile2);
			
			String dfile = pfix + originalFileName;
			
			try {
				/* MultipartFile�� transferTo(File dest)throws IOException, IllegalStateException �޼��� 
				  �� ���޹��� ��ü�� �Ķ������ ���� ��ü�� ���� 													*/
				mf.transferTo(new File(safeFile1)); // ������ �ش� ��ο� �ִ� ������ ���� ��ġ�� �̵����Ѷ�.
				mf.transferTo(new File(safeFile2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} // for���� ��
		
		return "complete";
	}	// uploadMulti()�� ��

	@RequestMapping("/download")	// ������ �ø��°� �ƴϱ⶧���� ���� ��ȯ �ʿ� X
	public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");
		// a href = "download?file_name=...."���� ��û�� ���� parameter�� ��ȯ
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096];
		// ������ �о�� ����Ʈ�� �����ϴ� �迭(�̹��� ���� �ؽ�Ʈ�� ���� �� �����Ƿ� stream�� ����)
		// ���Ϸκ��� �о���� InputStream(byte���·� �о��)
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		// ������ ���¸� ��Ÿ���� MimeType�� ���� �� type/subtype���� �����Ǹ�, type�� ī�װ��� subtype�� ������ Ÿ���� ����
		// text/plain, text/html, image/jpeg ��
		
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
										// ����Ʈ�� �����ڵ� ������� ��ȯ�϶�.
		// fileName���� UTF-8 ���·� �� byte ���� 8859-1 �� ���ڵ��Ͽ� ��ȯ
		// ���Ͽ��� �о�� ����Ʈ��Ʈ���� ���� ���ڵ� ����� response ��ü�� ����
		response.setHeader("Content-Disposition", "attachment; filename = " + sEncoding);
		// �о�� ����Ʈ��Ʈ���� ��� ��Ʈ���� ���ָ� client�� ����
		ServletOutputStream servletOutStream = response.getOutputStream();
		int numRead;
		while((numRead = fileInputStream.read(b,0,b.length)) != -1) {
										// read(�������Ʈ�迭, ���ۻ��ι�ȣ, �ִ� ����) : FileInputStream���� ���� ����Ʈ�� �� ������ ��ȯ 
										// -1 : ���� ���� ���� (EOF : End of File, ������ ���� ��Ÿ���� ����) �� -1�� ���ö����� (��� ����������) ��ȯ�ض�
			servletOutStream.write(b,0,numRead);
		}
		
		servletOutStream.flush();	// ���� Ŭ����

		servletOutStream.close();
		fileInputStream.close();
	}	// download()�� ��
}
