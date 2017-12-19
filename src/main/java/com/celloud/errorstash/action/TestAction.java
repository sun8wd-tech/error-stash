package com.celloud.errorstash.action;

import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午10:50
 */
@Controller
@RequestMapping("test")
public class TestAction {
    @Autowired
    private ErrorService errorService;

    @RequestMapping
    public String findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size, Model model) {
        model.addAttribute("pages", errorService.findAll(page >= 1 ? page - 1 : page, size));
        return "index";
    }
}
