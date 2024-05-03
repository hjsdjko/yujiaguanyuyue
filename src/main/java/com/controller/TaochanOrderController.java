
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
 * 套餐购买
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/taochanOrder")
public class TaochanOrderController {
    private static final Logger logger = LoggerFactory.getLogger(TaochanOrderController.class);

    private static final String TABLE_NAME = "taochanOrder";

    @Autowired
    private TaochanOrderService taochanOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    @Autowired
    private TaochanService taochanService;
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
        PageUtils page = taochanOrderService.queryPage(params);

        //字典表数据转换
        List<TaochanOrderView> list =(List<TaochanOrderView>)page.getList();
        for(TaochanOrderView c:list){
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
        TaochanOrderEntity taochanOrder = taochanOrderService.selectById(id);
        if(taochanOrder !=null){
            //entity转view
            TaochanOrderView view = new TaochanOrderView();
            BeanUtils.copyProperties( taochanOrder , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(taochanOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 套餐
            //级联表
            TaochanEntity taochan = taochanService.selectById(taochanOrder.getTaochanId());
            if(taochan != null){
            BeanUtils.copyProperties( taochan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTaochanId(taochan.getId());
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
    public R save(@RequestBody TaochanOrderEntity taochanOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,taochanOrder:{}",this.getClass().getName(),taochanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            taochanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        taochanOrder.setCreateTime(new Date());
        taochanOrder.setInsertTime(new Date());
        taochanOrderService.insert(taochanOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TaochanOrderEntity taochanOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,taochanOrder:{}",this.getClass().getName(),taochanOrder.toString());
        TaochanOrderEntity oldTaochanOrderEntity = taochanOrderService.selectById(taochanOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            taochanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<TaochanOrderEntity> queryWrapper = new EntityWrapper<TaochanOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaochanOrderEntity taochanOrderEntity = taochanOrderService.selectOne(queryWrapper);
        if(taochanOrderEntity==null){
            taochanOrderService.updateById(taochanOrder);//根据id更新
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
        List<TaochanOrderEntity> oldTaochanOrderList =taochanOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        taochanOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<TaochanOrderEntity> taochanOrderList = new ArrayList<>();//上传的东西
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
                            TaochanOrderEntity taochanOrderEntity = new TaochanOrderEntity();
//                            taochanOrderEntity.setTaochanId(Integer.valueOf(data.get(0)));   //套餐 要改的
//                            taochanOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            taochanOrderEntity.setTaochanOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            taochanOrderEntity.setTaochanOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            taochanOrderEntity.setTaochanOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            taochanOrderEntity.setInsertTime(date);//时间
//                            taochanOrderEntity.setCreateTime(date);//时间
                            taochanOrderList.add(taochanOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        taochanOrderService.insertBatch(taochanOrderList);
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
        PageUtils page = taochanOrderService.queryPage(params);

        //字典表数据转换
        List<TaochanOrderView> list =(List<TaochanOrderView>)page.getList();
        for(TaochanOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TaochanOrderEntity taochanOrder = taochanOrderService.selectById(id);
            if(taochanOrder !=null){


                //entity转view
                TaochanOrderView view = new TaochanOrderView();
                BeanUtils.copyProperties( taochanOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(taochanOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    TaochanEntity taochan = taochanService.selectById(taochanOrder.getTaochanId());
                if(taochan != null){
                    BeanUtils.copyProperties( taochan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTaochanId(taochan.getId());
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
    public R add(@RequestBody TaochanOrderEntity taochanOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,taochanOrder:{}",this.getClass().getName(),taochanOrder.toString());
            TaochanEntity taochanEntity = taochanService.selectById(taochanOrder.getTaochanId());
            if(taochanEntity == null){
                return R.error(511,"查不到该套餐");
            }
            // Double taochanNewMoney = taochanEntity.getTaochanNewMoney();

            if(false){
            }
            else if(taochanEntity.getTaochanNewMoney() == null){
                return R.error(511,"价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - taochanEntity.getTaochanNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            taochanOrder.setTaochanOrderTypes(101); //设置订单状态为已支付
            taochanOrder.setTaochanOrderTruePrice(taochanEntity.getTaochanNewMoney()*1); //设置实付价格
            taochanOrder.setYonghuId(userId); //设置订单支付人id
            taochanOrder.setTaochanOrderPaymentTypes(1);
            taochanOrder.setInsertTime(new Date());
            taochanOrder.setCreateTime(new Date());
                taochanOrderService.insert(taochanOrder);//新增订单
                yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            TaochanOrderEntity taochanOrder = taochanOrderService.selectById(id);
            Integer buyNumber = 1;
            Integer taochanOrderPaymentTypes = taochanOrder.getTaochanOrderPaymentTypes();
            Integer taochanId = taochanOrder.getTaochanId();
            if(taochanId == null)
                return R.error(511,"查不到该套餐");
            TaochanEntity taochanEntity = taochanService.selectById(taochanId);
            if(taochanEntity == null)
                return R.error(511,"查不到该套餐");
            Double taochanNewMoney = taochanEntity.getTaochanNewMoney();
            if(taochanNewMoney == null)
                return R.error(511,"套餐价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;


            //判断是什么支付方式 1代表余额 2代表积分
            if(taochanOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = taochanEntity.getTaochanNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            taochanOrder.setTaochanOrderTypes(102);//设置订单状态为退款
            taochanOrderService.updateById(taochanOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            taochanService.updateById(taochanEntity);//更新订单中套餐的信息

            return R.ok();
    }

    /**
     * 确定
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        TaochanOrderEntity  taochanOrderEntity = taochanOrderService.selectById(id);
        taochanOrderEntity.setTaochanOrderTypes(103);//设置订单状态为已确定
        boolean b =  taochanOrderService.updateById( taochanOrderEntity);

        if(!b){
            return R.error("确定出错");
        }
        return R.ok();
    }


}
