package com.demo.takeout.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.takeout.config.Mybean;
import com.demo.takeout.config.Zidingyi;
import com.demo.takeout.constant.PasswordConstant;
import com.demo.takeout.mapper.LawyerMapper;
import com.demo.takeout.pojo.dto.LoginDto;
import com.demo.takeout.pojo.dto.PageSearchParam;
import com.demo.takeout.pojo.entity.TLawyerInvestigationOrderModel;
import com.demo.takeout.pojo.entity.User;
import com.demo.takeout.pojo.vo.LoginVo;
import com.demo.takeout.pojo.vo.Result;
import com.demo.takeout.service.UserService;
import com.demo.takeout.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@Slf4j
public class TestDemo {

    @Resource
    private Zidingyi zidingyi;
    @Resource
    private Mybean mybean;
    @Resource
    private Docket docket;
    @Resource
    private UserService userService;
    @Resource
    private LawyerMapper dao;

    @GetMapping("/test")
    public String test(){
        String str = "test" +
                zidingyi.getA() + "-" +
                zidingyi.getB() +
                PasswordConstant.PASSWORD +
                mybean.a +
                docket;
        return str;
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){
        User user = userService.login(loginDto);

        Map<String,Object> claims = new HashMap<>();
        claims.put("id",user.getId());

        LoginVo loginVo = LoginVo.builder()
                .id(user.getId())
                .name(user.getName())
                .userName(user.getUsername())
                .token(JwtUtil.createJWT(zidingyi.getB(),zidingyi.getA(),claims))
                .build();
        return Result.success(loginVo);
    }

    @PostMapping("/parseJWT")
    public Result parseJWT(HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader("token");
        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(zidingyi.getB(), token);
            log.info("当前用户id：{}", claims.get("id").toString());
            //3、通过，放行
            return Result.success();
        } catch (Exception ex) {
            response.setStatus(401);
            return Result.success(401,"令牌无效",null);
        }
    }

    @PostMapping ("/selectPage")
    public Result selectPage(@RequestBody PageSearchParam pageSearchParam){
        return Result.success(dao.selectPage(new Page<>(pageSearchParam.getPage(), pageSearchParam.getLimit()), null));
    }

    @GetMapping ("/deleteById")
    public Result deleteById(@RequestParam("id") Long id){
        return Result.success(dao.deleteById(id));
    }

    @PostMapping ("/insert")
    public Result insert(@RequestBody TLawyerInvestigationOrderModel model){
        return Result.success(dao.insert(model));
    }

}
