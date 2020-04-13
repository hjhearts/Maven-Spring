package com.spring.work01.member;

import com.spring.work01.member.vo.MemberVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/*")
public class TestController {
    static Logger logger = Logger.getLogger(TestController.class);
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public void modify(@RequestBody MemberVO vo){
        logger.info(vo.toString());
    }
}
