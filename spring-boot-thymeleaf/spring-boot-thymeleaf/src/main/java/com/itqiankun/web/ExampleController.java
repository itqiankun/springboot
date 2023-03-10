package com.itqiankun.web;

import com.itqiankun.model.ItQianKunTree;
import com.itqiankun.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Controller
public class ExampleController {

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "ityouknow");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<User> list=new ArrayList<User>();
        User user1=new User("itqiankun.com",12,"876272");
        User user2=new User("小牛",6,"123563");
        User user3=new User("IT乾坤",66,"密码");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        map.addAttribute("users", list);
        return "list";
    }


    @RequestMapping("/tree")
    public String tree(ModelMap map) {
        List<ItQianKunTree> list= new ArrayList<>();
        ItQianKunTree firstItQianKunTree =new ItQianKunTree(1,"一级：itqiankun",0);
        ItQianKunTree firstItQianKunTree1 =new ItQianKunTree(4,"一级：马乾坤",0);
        ItQianKunTree secondItQianKunTree =new ItQianKunTree(2,"二级：itqiankun",1);
        ItQianKunTree secondItQianKunTree1 =new ItQianKunTree(3,"二级：itqiankun",1);
        ItQianKunTree thirdItQianKunTree =new ItQianKunTree(5,"三级：乾坤",2);
        list.add(firstItQianKunTree);
        list.add(firstItQianKunTree1);
        list.add(secondItQianKunTree);
        list.add(secondItQianKunTree1);
        list.add(thirdItQianKunTree);
        ItQianKunTree zeroItQianKunTree =new ItQianKunTree(0,"0级：root",-1);
        Map<Integer, List<ItQianKunTree>> treeMap = list.stream().collect(Collectors.groupingBy(ItQianKunTree::getParentId));
        list.forEach(node -> node.setChildren(treeMap.computeIfAbsent(node.getId(), k -> new ArrayList<>())));
        zeroItQianKunTree.setChildren(treeMap.computeIfAbsent(zeroItQianKunTree.getId(), k -> new ArrayList<>()));
        map.addAttribute("tree", zeroItQianKunTree);
        return "tree";
    }

    @RequestMapping("/map")
    public String map(ModelMap modelMap) {
        Map<Integer, User> userMap= new ConcurrentHashMap<>();
        User user1=new User("itqiankun.com",12,"876272");
        User user2=new User("小牛",6,"123563");
        User user3=new User("IT乾坤",66,"密码");
        userMap.put(user1.getAge(), user1);
        userMap.put(user2.getAge(), user2);
        userMap.put(user3.getAge(), user3);
        modelMap.addAttribute("userMap", userMap);

        Map<Integer, Object> interMap = new ConcurrentHashMap<>();
        interMap.put(1,"5");
        Map<String, Object> stringMap = new ConcurrentHashMap<>();
        stringMap.put("1","5");
        modelMap.addAttribute("interMap", interMap);
        modelMap.addAttribute("stringMap", stringMap);
        return "map";
    }
    @RequestMapping("/listMap")
    public String listMap(ModelMap modelMap) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> student = new HashMap<String, Object>(){{
            put("sid", "101");
            put("sname", "张三");
            put("sage", "20");
            put("scourse", new HashMap<String, String>(){{
                put("cname", "语文,数学,英语");
                put("cscore", "93,95,98");
            }});
        }};
        resultList.add(student);
        student = new HashMap<String, Object>(){{
            put("sid", "102");
            put("sname", "李四");
            put("sage", "30");
            put("scourse", new HashMap<String, String>(){{
                put("cname", "物理,化学,生物");
                put("cscore", "92,93,97");
            }});
        }};
        resultList.add(student);
        modelMap.addAttribute("resultList", resultList);

        return "list-map";
    }


    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "https://itqiankun.oss-cn-beijing.aliyuncs.com/picture/index/itqiankun_gongzhonghao.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "neo");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }


}