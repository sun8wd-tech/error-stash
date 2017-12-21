package com.celloud.errorstash.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.celloud.errorstash.config.StringToDateConverter;
import com.celloud.errorstash.model.Error;
import com.celloud.errorstash.model.QueryVo;
import com.celloud.errorstash.service.ErrorService;

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
    
    //根据id精确查询一个
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public  String findOne(@PathVariable("id") String id,Model model){
    	
    	Error error = errorService.findOne(id);
    	model.addAttribute("error", error);
    	
    	return "list";
    	
    }
    
    //多个条件组合查询
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String findByQuery(QueryVo queryVo,Model modle){
    	
    	List<Error> list=errorService.findByQuery(queryVo);
    	modle.addAttribute("list", list);
    	
    	
    	return "userList";
    	
    	
    }
}
