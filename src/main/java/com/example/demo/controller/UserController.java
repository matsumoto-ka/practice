package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserDto;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	// shianServiceのDI
	public UserController(UserService userService) {
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

	@RequestMapping("/output")
	public String result(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index.html";
		}

		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (userForm.getId() != null && userForm.getId() != "") {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}
		
		// サービス呼び出し
		List<UserDto> outUserDtoList = new ArrayList<UserDto>();
		outUserDtoList = userService.findByConditions(inDto);

		// 検索結果が0件でない場合、検索結果をuserListに設定する
		if (outUserDtoList.size() != 0) {
			model.addAttribute("userList", outUserDtoList);
		} else {
			model.addAttribute("message", "検索条件に該当するユーザー情報は存在しません");
		}
		return "output.html";
	}

	@RequestMapping("/edit")
	public String edit(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (userForm.getId() != null && userForm.getId() != "") {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		List<UserDto> outUserDtoList = new ArrayList<UserDto>();
		outUserDtoList = userService.findByConditions(inDto);

		// 検索結果が0件でない場合、検索結果をuserFormに設定する
		if (outUserDtoList != null) {
			BeanUtils.copyProperties(outUserDtoList.get(0), userForm);
			model.addAttribute("userForm", userForm);
		} else {
			model.addAttribute("user_name", "該当なし");
		}

		return "edit.html";
	}

	@RequestMapping("/update")
	public String update(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (userForm.getId() != null && userForm.getId() != "") {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		int resultCode = userService.update(inDto);

		// 更新結果に応じてメッセージを設定する
		if (resultCode != 0) {
			model.addAttribute("message", "更新が完了しました");
			
			// 更新後の情報を再検索
			this.edit(userForm, bindingResult, model);
		} else {
			model.addAttribute("message", "更新に失敗しました");
		}
		return "edit.html";
	}

	@RequestMapping("/delete")
	public String delete(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (userForm.getId() != null && userForm.getId() != "") {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		int resultCode = userService.delete(inDto);

		// 更新結果に応じてメッセージを設定する
		if (resultCode != 0) {
			model.addAttribute("message", "ID:" + userForm.getId() + "の情報を削除しました");
			
			// 更新後の情報を再検索（全件検索）
			userForm = new UserForm();
			this.result(userForm, bindingResult, model);
		} else {
			model.addAttribute("message", "削除に失敗しました");
		}
		return "output.html";
	}

	@RequestMapping("/register")
	public String register() {
		return "register.html";
	}

	@RequestMapping("/doRegister")
	public String doRegister(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (userForm.getId() != null && userForm.getId() != "") {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		int resultCode = userService.register(inDto);

		// 登録結果に応じてメッセージを設定する
		if (resultCode != 0) {
			model.addAttribute("message", "登録が完了しました");
		} else {
			model.addAttribute("message", "登録に失敗しました");
		}
		return "register.html";
	}
}