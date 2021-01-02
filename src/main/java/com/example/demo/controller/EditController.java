package com.example.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.UserDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("editController")
public class EditController {

	private final UserService userService;

	// shianServiceのDI
	public EditController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("/input")
	public String index() {
		return "index.html";
	}

	@RequestMapping(value = "edit", params = "return_edit", method = RequestMethod.POST)
	public String returnEdit(RegisterForm registerForm, BindingResult bindingResult, Model model) {
		// 誕生日を年月日に分割して設定
		String birthDate = registerForm.getBirth_date();
		registerForm.setBirth_year(birthDate.substring(0, 4));
		// DBに登録されている月・日が0埋めされていないため、下記の処理で暫定対処
		registerForm.setBirth_month(String.format("%2s", birthDate.substring(5, 7).replace("/", "")).replace(" ", "0"));
		registerForm.setBirth_day(
				String.format("%2s", birthDate.substring(birthDate.length() - 2).replace("/", "")).replace(" ", "0"));
		
		model.addAttribute("registerForm", registerForm);

		return "edit.html";
	}

	@RequestMapping(value = "edit", params = "update", method = RequestMethod.POST)
	public String update(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (!StringUtils.isEmpty(userForm.getId())) {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		int resultCode = userService.update(inDto);

		// 更新結果に応じてメッセージを設定する
		if (resultCode != 0) {
			model.addAttribute("message", "ID:" + userForm.getId() + "の情報を更新しました。");

			// formを初期化し、検索画面に戻る
			userForm = new UserForm();
			model.addAttribute("userForm", userForm);
			return "index.html";
		} else {
			model.addAttribute("message", "更新に失敗しました");
		}
		return "edit.html";
	}
}