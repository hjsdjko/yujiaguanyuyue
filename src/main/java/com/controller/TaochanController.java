
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
 * 套餐
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/taochan")
public class TaochanController {
    private static final Logger logger = LoggerFactory.getLogger(TaochanController.class);

    private static final String TABLE_NAME = "taochan";

    @Autowired
    private TaochanService taochanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private TaochanOrderService taochanOrderService;
    //级联表非注册的service
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
        params.put("taochanDeleteStart",1);params.put("taochanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = taochanService.queryPage(params);

        //字典表数据转换
        List<TaochanView> list =(List<TaochanView>)page.getList();
        for(TaochanView c:list){
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
        TaochanEntity taochan = taochanService.selectById(id);
        if(taochan !=null){
            //entity转view
            TaochanView view = new TaochanView();
            BeanUtils.copyProperties( taochan , view );//把实体数据重构到view中
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
    public R save(@RequestBody TaochanEntity taochan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,taochan:{}",this.getClass().getName(),taochan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TaochanEntity> queryWrapper = new EntityWrapper<TaochanEntity>()
            .eq("taochan_name", taochan.getTaochanName())
            .eq("taochan_types", taochan.getTaochanTypes())
            .eq("taochan_clicknum", taochan.getTaochanClicknum())
            .eq("shangxia_types", taochan.getShangxiaTypes())
            .eq("taochan_delete", taochan.getTaochanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaochanEntity taochanEntity = taochanService.selectOne(queryWrapper);
        if(taochanEntity==null){
            taochan.setTaochanClicknum(1);
            taochan.setShangxiaTypes(1);
            taochan.setTaochanDelete(1);
            taochan.setCreateTime(new Date());
            taochanService.insert(taochan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TaochanEntity taochan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,taochan:{}",this.getClass().getName(),taochan.toString());
        TaochanEntity oldTaochanEntity = taochanService.selectById(taochan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<TaochanEntity> queryWrapper = new EntityWrapper<TaochanEntity>()
            .notIn("id",taochan.getId())
            .andNew()
            .eq("taochan_name", taochan.getTaochanName())
            .eq("taochan_types", taochan.getTaochanTypes())
            .eq("taochan_clicknum", taochan.getTaochanClicknum())
            .eq("shangxia_types", taochan.getShangxiaTypes())
            .eq("taochan_delete", taochan.getTaochanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaochanEntity taochanEntity = taochanService.selectOne(queryWrapper);
        if("".equals(taochan.getTaochanPhoto()) || "null".equals(taochan.getTaochanPhoto())){
                taochan.setTaochanPhoto(null);
        }
        if(taochanEntity==null){
            taochanService.updateById(taochan);//根据id更新
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
        List<TaochanEntity> oldTaochanList =taochanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TaochanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TaochanEntity taochanEntity = new TaochanEntity();
            taochanEntity.setId(id);
            taochanEntity.setTaochanDelete(2);
            list.add(taochanEntity);
        }
        if(list != null && list.size() >0){
            taochanService.updateBatchById(list);
        }

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
            List<TaochanEntity> taochanList = new ArrayList<>();//上传的东西
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
                            TaochanEntity taochanEntity = new TaochanEntity();
//                            taochanEntity.setTaochanName(data.get(0));                    //套餐名称 要改的
//                            taochanEntity.setTaochanPhoto("");//详情和图片
//                            taochanEntity.setTaochanTypes(Integer.valueOf(data.get(0)));   //套餐类型 要改的
//                            taochanEntity.setTaochanNewMoney(data.get(0));                    //价格 要改的
//                            taochanEntity.setTaochanClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            taochanEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            taochanEntity.setTaochanDelete(1);//逻辑删除字段
//                            taochanEntity.setTaochanContent("");//详情和图片
//                            taochanEntity.setCreateTime(date);//时间
                            taochanList.add(taochanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        taochanService.insertBatch(taochanList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<TaochanView> returnTaochanViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = taochanOrderService.queryPage(params1);
        List<TaochanOrderView> orderViewsList =(List<TaochanOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(TaochanOrderView orderView:orderViewsList){
            Integer taochanTypes = orderView.getTaochanTypes();
            if(typeMap.containsKey(taochanTypes)){
                typeMap.put(taochanTypes,typeMap.get(taochanTypes)+1);
            }else{
                typeMap.put(taochanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("taochanTypes",type);
            PageUtils pageUtils1 = taochanService.queryPage(params2);
            List<TaochanView> taochanViewList =(List<TaochanView>)pageUtils1.getList();
            returnTaochanViewList.addAll(taochanViewList);
            if(returnTaochanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = taochanService.queryPage(params);
        if(returnTaochanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnTaochanViewList.size();//要添加的数量
            List<TaochanView> taochanViewList =(List<TaochanView>)page.getList();
            for(TaochanView taochanView:taochanViewList){
                Boolean addFlag = true;
                for(TaochanView returnTaochanView:returnTaochanViewList){
                    if(returnTaochanView.getId().intValue() ==taochanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnTaochanViewList.add(taochanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnTaochanViewList = returnTaochanViewList.subList(0, limit);
        }

        for(TaochanView c:returnTaochanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnTaochanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = taochanService.queryPage(params);

        //字典表数据转换
        List<TaochanView> list =(List<TaochanView>)page.getList();
        for(TaochanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TaochanEntity taochan = taochanService.selectById(id);
            if(taochan !=null){

                //点击数量加1
                taochan.setTaochanClicknum(taochan.getTaochanClicknum()+1);
                taochanService.updateById(taochan);

                //entity转view
                TaochanView view = new TaochanView();
                BeanUtils.copyProperties( taochan , view );//把实体数据重构到view中

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
    public R add(@RequestBody TaochanEntity taochan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,taochan:{}",this.getClass().getName(),taochan.toString());
        Wrapper<TaochanEntity> queryWrapper = new EntityWrapper<TaochanEntity>()
            .eq("taochan_name", taochan.getTaochanName())
            .eq("taochan_types", taochan.getTaochanTypes())
            .eq("taochan_clicknum", taochan.getTaochanClicknum())
            .eq("shangxia_types", taochan.getShangxiaTypes())
            .eq("taochan_delete", taochan.getTaochanDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TaochanEntity taochanEntity = taochanService.selectOne(queryWrapper);
        if(taochanEntity==null){
            taochan.setTaochanDelete(1);
            taochan.setCreateTime(new Date());
        taochanService.insert(taochan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
