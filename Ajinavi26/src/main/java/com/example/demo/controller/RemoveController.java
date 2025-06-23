package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewEditForm;
import com.example.demo.form.ReviewRemoveForm;
import com.example.demo.service.RemoveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RemoveController {
	
	private final RemoveService service;

	/*--- レビュー削除リクエスト（編集画面より） ---*/
	@PostMapping("/remove-review")
	public String removeReview(
			@Validated @ModelAttribute ReviewRemoveForm form,
			BindingResult result) {

		// 入力エラーがある場合には レビュー編集画面に戻す
		if (result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}
		
		// 正常な場合に レビュー編集確認画面に 遷移する
		return "confirm-remove-review";
	}

	/*--- レビュー削除リクエスト（削除確認画面より） ---*/
	@PostMapping("/confirm-remove-review")
	public String confirmEditReview(
			@Validated ReviewEditForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 入力エラーがある場合には レビュー編集画面に戻す
		if (result.hasErrors()) {
			throw new IllegalArgumentException("**removeReview()**");
		}

		Review r = new Review();
		r.setReviewId(form.getReviewId());
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		
		service.remove(r);
		
		redirectAttributes.addFlashAttribute("msg", "(レビュー削除)");
		
		return "redirect:/complete";
	}

}
