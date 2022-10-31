package com.kim.sp2101.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	public static JdbcTemplate template;
	// static멤버변수 (클래스 멤버변수)로 JVM에서 로딩 시 설정 → 종료될 때까지 유지 (응용프로그램 전체가 공동 사용)
}
