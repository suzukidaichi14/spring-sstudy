package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
@RequestMapping(value="/",method=RequestMethod.GET)
public ModelAndView indexGET(ModelAndView mv) {
	mv.addObject("name","名前がここに入ります");
	mv.addObject("age","年齢がここに入ります");
	mv.addObject("height","身長がここに入ります");
	mv.setViewName("index");
	return mv;
}

@RequestMapping(value="/",method=RequestMethod.POST)
public ModelAndView indexPOST(ModelAndView mv, @RequestParam("nameVal")String name,
@RequestParam("ageVal")String age, @RequestParam("heightVal")String height) {
mv.addObject("name", name);
mv.addObject("age", age);
mv.addObject("height", height);
mv.setViewName("index");
return mv;
}

@RequestMapping(value="/ifstudy",method=RequestMethod.GET)
public ModelAndView indexifstudyGet(ModelAndView mv) {
	mv.addObject("suzuki",false);
	mv.setViewName("ifstudy");
	return mv;
}
@RequestMapping(value="/ifstudy",method=RequestMethod.POST)
public ModelAndView indexifstudyPost(ModelAndView mv) {
	mv.addObject("suzuki",true);
	mv.setViewName("ifstudy");
	return mv;

}

@RequestMapping(value="/task1",method=RequestMethod.GET)
public ModelAndView indextask1Get(ModelAndView mv) {
	mv.addObject("answer","階乗の計算をします。"); 
	mv.setViewName("task1");
	return mv;
}
@RequestMapping(value="/task1",method=RequestMethod.POST)
public ModelAndView indextask1POST (ModelAndView mv,@RequestParam("num") int num) {
	int a=1;
	for(int i=2; i<=num;i++) {
		a+=i;
		}
	mv.addObject("answer",num+"の階乗は"+a+"です。");
	mv.setViewName("task1");
return mv;
}
@RequestMapping("/{name}")
public ModelAndView index(@PathVariable String name,ModelAndView mv) {
	mv.addObject("name",name);
	mv.setViewName("url");
	return mv;
}
@RequestMapping("/url/{num}")
public ModelAndView i(@PathVariable int num, ModelAndView mv) {
	String line="";
	for(int i=0;i<num;i++)line+="あ";
	mv.addObject("num",line);
	mv.setViewName("url");
	return mv;
	
}
@RequestMapping(value="/eachstudy")
public ModelAndView indexPOST(ModelAndView mv) {
	ArrayList<String[]>customers=new ArrayList<String[]>();
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性"});
	customers.add(new String[] {"鈴木JAVA太郎","24歳","男性"});
	customers.add(new String[] {"高橋CSS子","29歳","女性"});
	mv.addObject("customers",customers);
	mv.setViewName("eachstudy");
	return mv;
}
@RequestMapping(value="/task2/{num}")
public ModelAndView index(@PathVariable int num, ModelAndView mv) {
	if(num<2) {
		mv.addObject("answer",num +"は素数ではありません…");
		mv.setViewName("task2");
		return mv;
	}
	for(int i=2;i<num;i++) {
		if(num%2==0) {
			mv.addObject("answer",num +"は素数ではありません…");
			mv.setViewName("task2");
			return mv;
		}
	}
		mv.addObject("answer",num +"は素数です");
		mv.setViewName("task2");
	return mv;
}
}

