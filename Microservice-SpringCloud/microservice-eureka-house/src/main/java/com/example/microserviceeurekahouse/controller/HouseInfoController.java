package com.example.microserviceeurekahouse.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microserviceeurekahouse.entity.Collect;
import com.example.microserviceeurekahouse.mapper.CollectMapper;
import com.example.microserviceeurekahouse.vo.HouseInfoQueryVO;
import com.example.microserviceeurekahouse.entity.HouseInfoVO;
import com.example.microserviceeurekahouse.entity.Result;
import com.example.microserviceeurekahouse.entity.HouseInfo;
import com.example.microserviceeurekahouse.mapper.HouseInfoMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;


@RestController
public class HouseInfoController {
    @Autowired
    HouseInfoMapper houseInfoMapper;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    /**
     * 新增
     * @param houseInfoVO
     * @return
     */
    @ApiOperation(value="创建租房信息", notes="创建租房信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result create(@RequestBody HouseInfoVO houseInfoVO){
        Result result = new Result(null);
        if(houseInfoVO.getAddress().length() < 1 || houseInfoVO.getPrice().equals(null)
                || houseInfoVO.getTitle().length() < 1){
            result.setMsg("输入不能为空");
            return result;
        }
        HouseInfo houseInfo = new HouseInfo(houseInfoVO);
        houseInfo.setTime(new Date());
        houseInfo.setStatus(2);     //创建时等待审核状态
        houseInfoMapper.insert(houseInfo);
        this.restTemplate.getForObject("http://microservice-eureka-userhouserelation/create?houseId="+
                houseInfo.getId() + "&userId=" + houseInfoVO.getUserId(), Result.class);
        result.setMsg("创建成功");
        return result;
    }

    /**
     * 查看租房信息
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "fallbackInfo")
    @ApiOperation(value="查看租房信息", notes="查看租房信息")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result query(@RequestParam String id){
        HouseInfoVO houseInfoVO = houseInfoMapper.queryHouseInfoVO(id);
        return new Result(houseInfoVO);
    }

    /**
     * 更新租房信息
     * @param houseInfo
     * @return
     */
    @ApiOperation(value="更新租房信息", notes="更新租房信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody HouseInfo houseInfo){
        houseInfoMapper.updateById(houseInfo);
        Result result = new Result("");
        result.setMsg("修改成功");
        return result;
    }

    /**
     * 删除租房信息
     * @param id
     * @return
     */
    @ApiOperation(value="删除租房信息", notes="删除租房信息")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteById(@RequestParam String id){
        houseInfoMapper.deleteById(id);
        Result result = new Result("");
        result.setMsg("删除成功");
        return result;
    }

    /**
     * 获取所有租房信息
     * @return
     */
//    @HystrixCommand(fallbackMethod = "fallbackInfo2")
    @ApiOperation(value="获取所有租房信息", notes="获取所有租房信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam(value = "keyword", defaultValue = "",required = false) String keyword,
                       @RequestParam(value = "orderBy", defaultValue = "", required = false) String orderBy) throws InterruptedException {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(keyword != null && keyword.length() > 0){
            queryWrapper.like("title", keyword);
        }
        if(orderBy != null && orderBy.length() > 0){
            queryWrapper.orderByDesc(orderBy);
        }
        queryWrapper.eq("status", 1);//通过审核的
        List<HouseInfo> list = houseInfoMapper.selectList(queryWrapper);
        return new Result(list);
    }

    /**
     * 获取用户所有租房信息
     * @return
     */
//    @HystrixCommand(fallbackMethod = "fallbackInfo2")
    @ApiOperation(value="获取用户所有租房信息", notes="获取用户所有租房信息")
    @RequestMapping(value = "/listByUserId", method = RequestMethod.GET)
    public Result listByUserId(@RequestParam(value = "keyword", defaultValue = "",required = false) String keyword,
                       @RequestParam(value = "orderBy", defaultValue = "", required = false) String orderBy,
                       @RequestParam(value = "status", defaultValue = "0", required = false) int status,
                       @RequestParam(value = "userId", defaultValue = "", required = false) String userId) throws InterruptedException {
        HouseInfoQueryVO houseInfoQueryVO = new HouseInfoQueryVO(userId, orderBy, keyword, status);
        List<HouseInfo> list = houseInfoMapper.listByUserId(houseInfoQueryVO);
        return new Result(list);
    }


    /**
     * 获取用户所有租房信息
     * @return
     */
    @ApiOperation(value="获取用户所有租房信息", notes="获取用户所有租房信息")
    @RequestMapping(value = "/listByUserIdCollect", method = RequestMethod.GET)
    public Result listByUserIdCollect(@RequestParam(value = "keyword", defaultValue = "",required = false) String keyword,
                               @RequestParam(value = "orderBy", defaultValue = "", required = false) String orderBy,
                               @RequestParam(value = "userId", defaultValue = "", required = false) String userId) throws InterruptedException {
        System.out.println(keyword+orderBy+userId);
        HouseInfoQueryVO houseInfoQueryVO = new HouseInfoQueryVO(userId, orderBy, keyword);
        List<HouseInfo> list = houseInfoMapper.listByUserIdCollect(houseInfoQueryVO);
        return new Result(list);
    }

    /**
     * 增加销量
     * @return
     */
    @ApiOperation(value="增加销量", notes="增加销量")
    @RequestMapping(value = "/addSale", method = RequestMethod.PUT)
    public Result addSale(@RequestParam(value = "id", defaultValue = "",required = false) String id) throws InterruptedException {
        houseInfoMapper.addSale(id);
        Result result = new Result("");
        result.setMsg("购买成功");
        return result;
    }

    /**
     * 审核通过
     * @return
     */
    @ApiOperation(value="审核通过", notes="审核通过")
    @RequestMapping(value = "/pass", method = RequestMethod.PUT)
    public Result pass(@RequestParam(value = "id", defaultValue = "",required = false) String id) throws InterruptedException {
        houseInfoMapper.pass(id);
        Result result = new Result("");
        result.setMsg("审核通过");
        return result;
    }

    /**
     * 审核不通过
     * @return
     */
    @ApiOperation(value="审核不通过", notes="审核不通过")
    @RequestMapping(value = "/unpass", method = RequestMethod.PUT)
    public Result unpass(@RequestParam(value = "id", defaultValue = "",required = false) String id) throws InterruptedException {
        houseInfoMapper.unpass(id);
        Result result = new Result("");
        result.setMsg("审核不通过");
        return result;
    }

    /**
     * 收藏
     * @return
     */
    @ApiOperation(value="收藏", notes="收藏")
    @RequestMapping(value = "/collect", method = RequestMethod.PUT)
    public Result collect(@RequestParam(value = "userId", defaultValue = "",required = false) String userId,
                       @RequestParam(value = "houseId", defaultValue = "",required = false) String houseId) throws InterruptedException {
        Result result = new Result("");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("houseId", houseId);
        Collect collectQ =  collectMapper.selectOne(queryWrapper);
        if(collectQ!=null){
            result.setMsg("已经收藏过了");
            return result;
        }
        Collect collect = new Collect(userId, houseId);
        collectMapper.insert(collect);

        result.setMsg("收藏成功");
        return result;
    }
    /**
     * 取消收藏
     * @return
     */
    @ApiOperation(value="取消收藏", notes="取消收藏")
    @RequestMapping(value = "/deleteCollect", method = RequestMethod.DELETE)
    public Result deleteCollect(@RequestParam(value = "userId", defaultValue = "",required = false) String userId,
                       @RequestParam(value = "houseId", defaultValue = "",required = false) String houseId) throws InterruptedException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("houseId", houseId);
        collectMapper.delete(queryWrapper);
        Result result = new Result("");
        result.setMsg("取消成功");
        return result;
    }


    public Result fallbackInfo(@PathVariable("id") String id){
        Result result = new Result();
        result.setMsg("服务不可用请稍后重试");
        return result;
    }

    public Result fallbackInfo2(@PathVariable("keyword") String keyword,
                                @PathVariable("orderBy") String orderBy){
        Result result = new Result();
        result.setMsg("服务不可用请稍后重试");
        return result;
    }
}
