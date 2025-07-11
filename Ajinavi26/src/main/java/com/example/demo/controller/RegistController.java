package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

//登録用コントローラー

@Controller
@RequiredArgsConstructor
public class RegistController {
	
	private final RegistService service;

	@PostMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		
		return "regist-review";
	}
	
	@PostMapping("/regist-review")
	public String registReview(@Validated @ModelAttribute ReviewRegistForm form,BindingResult result) {
		
		if(result.hasErrors()) {
			return "regist-review";
		}
		
		return "confirm-regist-review";
	}
	
	@PostMapping("/show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form){
		
		return "regist-review";
	}	
	
	@PostMapping("/confirm-regist-review")
	public String comfirmRegistReview(@Validated @ModelAttribute ReviewRegistForm form,BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		
		
		
		if(result.hasErrors()) {
			return "regist-review";
		}
		
		Review r = new Review();
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setRating(form.getRating());
		r.setVisitDate(form.getVisitDate());
		r.setComment(form.getComment());
		service.regist(r);
		
		redirectAttributes.addFlashAttribute("msg","（レビュー登録）");//redirectAttributesオブジェクトによってフラッシュモデルに追加（フラッシュモデルは次のレスポンスまでモデルに残る）
		
		return "redirect:/complete";//URLにリダイレクトする（Getリクエスト）→コモンコントローラーによってcomplete.htmlが表示される
	}

}
