package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.lab.app.ketman.mybatis.domain.UserMstWithBLOBs;

@Controller
@RequestMapping("userController")
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

	//@RequestMapping("/output")
	@RequestMapping(value = "output", params = "output", method = RequestMethod.POST)
	public String result(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index.html";
		}

		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (!(StringUtils.isEmpty(userForm.getId()))) {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}

		// サービス呼び出し
		List<UserMstWithBLOBs> outUserDtoList = new ArrayList<UserMstWithBLOBs>();
		outUserDtoList = userService.findByConditions(inDto);

		// 検索結果が0件でない場合、検索結果をuserListに設定する
		if (outUserDtoList.size() != 0) {
			model.addAttribute("userList", outUserDtoList);
		} else {
			model.addAttribute("message", "検索条件に該当するユーザー情報は存在しません");
		}
		return "output.html";
	}

	//@RequestMapping("/edit")
	@RequestMapping(value = "edit", params = "edit", method = RequestMethod.POST)
	public String edit(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(userForm, inDto);
		if (!(StringUtils.isEmpty(userForm.getId()))) {
			inDto.setId(Integer.parseInt(userForm.getId()));
		}
		
		// サービス呼び出し
		List<UserMstWithBLOBs> outUserDtoList = new ArrayList<UserMstWithBLOBs>();
		outUserDtoList = userService.findByConditions(inDto);

		// 検索結果が0件でない場合、検索結果をuserFormに設定する
		if (outUserDtoList != null) {
			RegisterForm registerForm = new RegisterForm();
			// Formに値を設定
			BeanUtils.copyProperties(outUserDtoList.get(0), registerForm);
			registerForm.setId(outUserDtoList.get(0).getId().toString());
			registerForm.setSex(outUserDtoList.get(0).getSex().toString());
			registerForm.setAge(outUserDtoList.get(0).getAge().toString());
			registerForm.setTel(outUserDtoList.get(0).getTel().toString());
			registerForm.setPostal_code(outUserDtoList.get(0).getPostal_code().toString());
			
			// 誕生日を年月日に分割して設定
			String birthDate = outUserDtoList.get(0).getBirth_date();
			registerForm.setBirth_year(birthDate.substring(0, 4));
			// DBに登録されている月・日が0埋めされていないため、下記の処理で暫定対処
			registerForm
					.setBirth_month(String.format("%2s", birthDate.substring(5, 7).replace("/", "")).replace(" ", "0"));
			registerForm.setBirth_day(String.format("%2s", birthDate.substring(birthDate.length() - 2).replace("/", ""))
					.replace(" ", "0"));

			model.addAttribute("registerForm", registerForm);
		} else {
			model.addAttribute("user_name", "該当なし");
		}

		return "edit.html";
	}

	//@RequestMapping("/edit_confirm")
	@RequestMapping(value = "edit_confirm", params = "edit_confirm", method = RequestMethod.POST)
	public String editConfirm(@Validated RegisterForm registerForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "edit.html";
		}
		registerForm.setBirth_date(
				registerForm.getBirth_year() + "/" + registerForm.getBirth_month() + "/" + registerForm.getBirth_day());

		model.addAttribute("registerForm", registerForm);
		model.addAttribute("message", "編集結果を確認し、よろしければ「更新」をクリックしてください。");
		return "edit_confirm.html";
	}

	//@RequestMapping("/delete")
	@RequestMapping(value = "delete", params = "delete", method = RequestMethod.POST)
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
	//@RequestMapping(value = "register", params = "register", method = RequestMethod.POST)
	public String register(RegisterForm registerForm, BindingResult bindingResult, Model model) {
		model.addAttribute("registerForm", registerForm);
		return "register.html";
	}

	//@RequestMapping("/register_confirm")
	@RequestMapping(value = "register", params = "register_confirm", method = RequestMethod.POST)
	public String registerConfirm(@Validated RegisterForm registerForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register.html";
		}
		registerForm.setBirth_date(
				registerForm.getBirth_year() + "/" + registerForm.getBirth_month() + "/" + registerForm.getBirth_day());
		model.addAttribute("registerForm", registerForm);
		model.addAttribute("message", "登録結果を確認し、よろしければ「登録」をクリックしてください。");
		return "register_confirm.html";
	}
	
	//@RequestMapping("/return_register")
	@RequestMapping(value = "register", params = "return_register", method = RequestMethod.POST)
	public String returnRegister(RegisterForm registerForm, BindingResult bindingResult, Model model) {
		// 誕生日を年月日に分割して設定
		String birthDate = registerForm.getBirth_date();
		registerForm.setBirth_year(birthDate.substring(0, 4));
		// DBに登録されている月・日が0埋めされていないため、下記の処理で暫定対処
		registerForm.setBirth_month(String.format("%2s", birthDate.substring(5, 7).replace("/", "")).replace(" ", "0"));
		registerForm.setBirth_day(
				String.format("%2s", birthDate.substring(birthDate.length() - 2).replace("/", "")).replace(" ", "0"));
		
		model.addAttribute("registerForm", registerForm);

		return "register.html";
	}

	//@RequestMapping("/doRegister")
	@RequestMapping(value = "register", params = "doRegister", method = RequestMethod.POST)
	public String doRegister(@Validated RegisterForm registerForm, BindingResult bindingResult, Model model) {
		// FormからDTOに転記
		UserDto inDto = new UserDto();
		BeanUtils.copyProperties(registerForm, inDto);

		// サービス呼び出し
		int resultCode = userService.register(inDto);

		// 登録結果に応じてメッセージを設定する
		if (resultCode != 0) {
			model.addAttribute("message", "登録が完了しました");
		} else {
			model.addAttribute("message", "登録に失敗しました");
		}
		return "index.html";
	}
}