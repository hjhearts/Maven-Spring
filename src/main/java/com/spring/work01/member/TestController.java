package com.spring.work01.member;

import com.spring.work01.member.vo.MemberVO;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/*")
public class TestController {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<List<MemberVO>> listMembers(){
        List<MemberVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MemberVO vo = new MemberVO("test"+i, "123"+i, "test"+i, "test"+i+"@test.com");
            list.add(vo);
        }
        return new ResponseEntity<>(list, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
