package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//リダイレクト用コントローラー
@Controller
public class CommonController {
	
	@GetMapping("/complete")
	private String complete() {
		return "complete";
	}
}
