
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 瑜伽预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yujiaOrder")
public class YujiaOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YujiaOrderController.class);

    private static final String TABLE_NAME = "yujiaOrder";

    @Autowired
    private YujiaOrderService yujiaOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private YujiaService yujiaService;
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JiaolianService jiaolianService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yujiaOrderService.queryPage(params);

        //字典表数据转换
        List<YujiaOrderView> list =(List<YujiaOrderView>)page.getList();
        for(YujiaOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YujiaOrderEntity yujiaOrder = yujiaOrderService.selectById(id);
        if(yujiaOrder !=null){
            //entity转view
            YujiaOrderView view = new YujiaOrderView();
            BeanUtils.copyProperties( yujiaOrder , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yujiaOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 瑜伽
            //级联表
            YujiaEntity yujia = yujiaService.selectById(yujiaOrder.getYujiaId());
            if(yujia != null){
            BeanUtils.copyProperties( yujia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYujiaId(yujia.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YujiaOrderEntity yujiaOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yujiaOrder:{}",this.getClass().getName(),yujiaOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yujiaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yujiaOrder.setCreateTime(new Date());
        yujiaOrder.setInsertTime(new Date());
        yujiaOrderService.insert(yujiaOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YujiaOrderEntity yujiaOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yujiaOrder:{}",this.getClass().getName(),yujiaOrder.toString());
        YujiaOrderEntity oldYujiaOrderEntity = yujiaOrderService.selectById(yujiaOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yujiaOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YujiaOrderEntity> queryWrapper = new EntityWrapper<YujiaOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujiaOrderEntity yujiaOrderEntity = yujiaOrderService.selectOne(queryWrapper);
        if(yujiaOrderEntity==null){
            yujiaOrderService.updateById(yujiaOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YujiaOrderEntity> oldYujiaOrderList =yujiaOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yujiaOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YujiaOrderEntity> yujiaOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YujiaOrderEntity yujiaOrderEntity = new YujiaOrderEntity();
//                            yujiaOrderEntity.setYujiaId(Integer.valueOf(data.get(0)));   //瑜伽 要改的
//                            yujiaOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yujiaOrderEntity.setYujiaOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            yujiaOrderEntity.setYujiaOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            yujiaOrderEntity.setYujiaOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            yujiaOrderEntity.setInsertTime(date);//时间
//                            yujiaOrderEntity.setCreateTime(date);//时间
                            yujiaOrderList.add(yujiaOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yujiaOrderService.insertBatch(yujiaOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yujiaOrderService.queryPage(params);

        //字典表数据转换
        List<YujiaOrderView> list =(List<YujiaOrderView>)page.getList();
        for(YujiaOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YujiaOrderEntity yujiaOrder = yujiaOrderService.selectById(id);
            if(yujiaOrder !=null){


                //entity转view
                YujiaOrderView view = new YujiaOrderView();
                BeanUtils.copyProperties( yujiaOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yujiaOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YujiaEntity yujia = yujiaService.selectById(yujiaOrder.getYujiaId());
                if(yujia != null){
                    BeanUtils.copyProperties( yujia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYujiaId(yujia.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YujiaOrderEntity yujiaOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yujiaOrder:{}",this.getClass().getName(),yujiaOrder.toString());
            YujiaEntity yujiaEntity = yujiaService.selectById(yujiaOrder.getYujiaId());
            if(yujiaEntity == null){
                return R.error(511,"查不到该瑜伽");
            }
            // Double yujiaNewMoney = yujiaEntity.getYujiaNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            yujiaOrder.setYujiaOrderTypes(101); //设置订单状态为已支付
            yujiaOrder.setYonghuId(userId); //设置订单支付人id
            yujiaOrder.setYujiaOrderPaymentTypes(1);
            yujiaOrder.setInsertTime(new Date());
            yujiaOrder.setCreateTime(new Date());
            yujiaOrder.setYujiaOrderTime(yujiaOrder.getYujiaOrderTime());
                yujiaOrderService.insert(yujiaOrder);//新增订单


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            YujiaOrderEntity yujiaOrder = yujiaOrderService.selectById(id);
            Integer yujiaOrderPaymentTypes = yujiaOrder.getYujiaOrderPaymentTypes();
            Integer yujiaId = yujiaOrder.getYujiaId();
            if(yujiaId == null)
                return R.error(511,"查不到该瑜伽");
            YujiaEntity yujiaEntity = yujiaService.selectById(yujiaId);
            if(yujiaEntity == null)
                return R.error(511,"查不到该瑜伽");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;



            yujiaOrder.setYujiaOrderTypes(102);//设置订单状态为取消预约
            yujiaOrderService.updateById(yujiaOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            yujiaService.updateById(yujiaEntity);//更新订单中瑜伽的信息

            return R.ok();
    }

    /**
     * 完成
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YujiaOrderEntity  yujiaOrderEntity = yujiaOrderService.selectById(id);
        yujiaOrderEntity.setYujiaOrderTypes(103);//设置订单状态为已完成
        boolean b =  yujiaOrderService.updateById( yujiaOrderEntity);

        if(!b){
            return R.error("完成出错");
        }
        return R.ok();
    }


}
