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
 - form의 enctype이 multipart/form-data일 때 이를 처리하는 어노테이션
 - maxFileSize : 용량 제한 / 1024*1024*5 → 5MB              
 - maxRequestSize : request 객체에 실을 수 있는 최대 사이즈. 보통 default로 설정(-1). 무한대
 - location : 파일 위치 (절대 경로) 												*/
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
	} // home()의 끝
	
	@RequestMapping("/uploadSingle")
	public String uploadSingle(MultipartHttpServletRequest mtpRequest, Model model) {
		/* MultipartHttpServletRequest 
		 - enctype = "multipart/form-data" 처리 시 MultipartHttpServletRequest 객체 사용
		 - form의 파라메터 값 → getParameter() 메서드로 변환 								*/
		String src = mtpRequest.getParameter("src"); // 업로드한 사람의 이름 (input의 name 속성)
		System.out.println("업로더 : " + src);
		// form에 올린 파일은 getFile("name속성")
		MultipartFile mf = mtpRequest.getFile("file");
		/* MultipartFile MultipartRequest.getFile(String name) 
		 - form에서 온 파일 객체 → MultipartFile 객체임!			*/
																		/* 저장 경로 표시 */
		String path1 = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String path2 = "C:\\KIMKIM\\apache-tomcat-9.0.63\\wtpwebapps\\SP_CH16EX01\\resources\\upimage\\";
		/* path1 : 프로젝트의 저장 위치 
		   path2 : 이때 tomcat서버에서도 임시로 파일을 자기 경로에 저장함 → tomcat서버 저장 위치 
		   이클립스에서 실행 시 사진의 이미지가 바로 보이지 않는 경우가 있어 tomcat에 같이 저장 (실제 서비스 시에는 path2 필요X) */
		
		// form에서 보낸 파일 이름 
		String originalFileName = mf.getOriginalFilename();
		// 원래 파일의 파일 사이즈(long형 바이트 단위)
		long fileSize = mf.getSize();
		System.out.println("originalFileName : " + originalFileName);
		System.out.println("fileSize : " + fileSize);
		// 업로드된 파일들은 동일한 이름을 갖는 경우가 많으므로 유일한 이름으로 변경하여 저장해야 한다.
		// 유일 구분자로 System.currentTimeMillis()를 파일명 앞에 붙임
		long pfix = System.currentTimeMillis();
		String safeFile1 = path1 + pfix + originalFileName;	// pfix + originalFileName 이 업로드된 파일의 이름이 됨
		String safeFile2 = path2 + pfix + originalFileName; 
		System.out.println("safeFile1 : " + safeFile1);
		System.out.println("safeFile2 : " + safeFile2);
		
		String dfile = pfix + originalFileName; // 다운로드 테스트용 파일 이름
		try {
			/* MultipartFile의 transferTo(File dest)throws IOException, IllegalStateException 메서드 
			  → 전달받은 객체를 파라메터의 파일 객체로 저장 													*/
			mf.transferTo(new File(safeFile1)); // 지정된 해당 경로에 있는 파일을 저장 위치로 이동시켜라.
			mf.transferTo(new File(safeFile2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 이동할 페이지 download.jsp에서 사용할 데이터값
		model.addAttribute("author", src);
		model.addAttribute("fileName", dfile);
		model.addAttribute("fileSize", fileSize);
		
		return "download";
		
	} // uploadSingle()의 끝

	@RequestMapping("/uploadMulti")
	public String uploadMulti(MultipartHttpServletRequest mtpRequest, Model model) {
		List<MultipartFile> fileList = mtpRequest.getFiles("file");
		// List<MultipartFile> MultipartRequest.getFiles(String name)
		String src = mtpRequest.getParameter("src");
		System.out.println("올린사람 : " + src);
		
				/* 저장 경로 표시 */
		String path1 = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String path2 = "C:\\KIMKIM\\apache-tomcat-9.0.63\\wtpwebapps\\SP_CH16EX01\\resources\\upimage\\";
		
			/* 업로드한 파일 개수만큼 반복 */
		for(MultipartFile mf : fileList) {
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			System.out.println("OriginalFileName : " + originalFileName);
			System.out.println("fileSize : " + fileSize);
			
			long pfix = System.currentTimeMillis();
			String safeFile1 = path1 + pfix + originalFileName;	// pfix + originalFileName 이 업로드된 파일의 이름이 됨
			String safeFile2 = path2 + pfix + originalFileName; 
			System.out.println("safeFile1 : " + safeFile1);
			System.out.println("safeFile2 : " + safeFile2);
			
			String dfile = pfix + originalFileName;
			
			try {
				/* MultipartFile의 transferTo(File dest)throws IOException, IllegalStateException 메서드 
				  → 전달받은 객체를 파라메터의 파일 객체로 저장 													*/
				mf.transferTo(new File(safeFile1)); // 지정된 해당 경로에 있는 파일을 저장 위치로 이동시켜라.
				mf.transferTo(new File(safeFile2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} // for문의 끝
		
		return "complete";
	}	// uploadMulti()의 끝

	@RequestMapping("/download")	// 파일을 올리는게 아니기때문에 굳이 반환 필요 X
	public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");
		// a href = "download?file_name=...."으로 요청한 것의 parameter를 반환
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "C:\\Users\\310\\Desktop\\kim\\workspace\\SP_CH16EX01\\src\\main\\webapp\\resources\\upimage\\";
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096];
		// 파일을 읽어와 바이트로 저장하는 배열(이미지 등은 텍스트로 받을 수 없으므로 stream을 받음)
		// 파일로부터 읽어오는 InputStream(byte형태로 읽어옴)
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		// 파일의 형태를 나타내는 MimeType을 구함 → type/subtype으로 구성되며, type은 카테고리고 subtype은 각각의 타입을 말함
		// text/plain, text/html, image/jpeg 등
		
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
										// 바이트를 유니코드 방식으로 변환하라.
		// fileName에서 UTF-8 형태로 된 byte 값을 8859-1 로 인코딩하여 변환
		// 파일에서 읽어온 바이트스트림에 대한 인코딩 방식을 response 객체에 설정
		response.setHeader("Content-Disposition", "attachment; filename = " + sEncoding);
		// 읽어온 바이트스트림을 출력 스트림에 써주면 client로 전달
		ServletOutputStream servletOutStream = response.getOutputStream();
		int numRead;
		while((numRead = fileInputStream.read(b,0,b.length)) != -1) {
										// read(저장바이트배열, 시작색인번호, 최대 개수) : FileInputStream에서 읽은 바이트의 총 개수를 반환 
										// -1 : 읽은 값이 없음 (EOF : End of File, 파일의 끝을 나타내는 숫자) → -1이 나올때까지 (모두 읽을때까지) 반환해라
			servletOutStream.write(b,0,numRead);
		}
		
		servletOutStream.flush();	// 버퍼 클리어

		servletOutStream.close();
		fileInputStream.close();
	}	// download()의 끝
}
