
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
 * 瑜伽
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yujia")
public class YujiaController {
    private static final Logger logger = LoggerFactory.getLogger(YujiaController.class);

    private static final String TABLE_NAME = "yujia";

    @Autowired
    private YujiaService yujiaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private YujiaOrderService yujiaOrderService;
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
        params.put("yujiaDeleteStart",1);params.put("yujiaDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yujiaService.queryPage(params);

        //字典表数据转换
        List<YujiaView> list =(List<YujiaView>)page.getList();
        for(YujiaView c:list){
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
        YujiaEntity yujia = yujiaService.selectById(id);
        if(yujia !=null){
            //entity转view
            YujiaView view = new YujiaView();
            BeanUtils.copyProperties( yujia , view );//把实体数据重构到view中
            //级联表 教练
            //级联表
            JiaolianEntity jiaolian = jiaolianService.selectById(yujia.getJiaolianId());
            if(jiaolian != null){
            BeanUtils.copyProperties( jiaolian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "jiaolianId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiaolianId(jiaolian.getId());
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
    public R save(@RequestBody YujiaEntity yujia, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yujia:{}",this.getClass().getName(),yujia.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("教练".equals(role))
            yujia.setJiaolianId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YujiaEntity> queryWrapper = new EntityWrapper<YujiaEntity>()
            .eq("yujia_name", yujia.getYujiaName())
            .eq("yujia_types", yujia.getYujiaTypes())
            .eq("yujia_address", yujia.getYujiaAddress())
            .eq("jiaolian_id", yujia.getJiaolianId())
            .eq("yujia_clicknum", yujia.getYujiaClicknum())
            .eq("shangxia_types", yujia.getShangxiaTypes())
            .eq("yujia_delete", yujia.getYujiaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujiaEntity yujiaEntity = yujiaService.selectOne(queryWrapper);
        if(yujiaEntity==null){
            yujia.setYujiaClicknum(1);
            yujia.setShangxiaTypes(1);
            yujia.setYujiaDelete(1);
            yujia.setCreateTime(new Date());
            yujiaService.insert(yujia);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YujiaEntity yujia, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yujia:{}",this.getClass().getName(),yujia.toString());
        YujiaEntity oldYujiaEntity = yujiaService.selectById(yujia.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("教练".equals(role))
//            yujia.setJiaolianId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YujiaEntity> queryWrapper = new EntityWrapper<YujiaEntity>()
            .notIn("id",yujia.getId())
            .andNew()
            .eq("yujia_name", yujia.getYujiaName())
            .eq("yujia_types", yujia.getYujiaTypes())
            .eq("yujia_address", yujia.getYujiaAddress())
            .eq("jiaolian_id", yujia.getJiaolianId())
            .eq("yujia_clicknum", yujia.getYujiaClicknum())
            .eq("shangxia_types", yujia.getShangxiaTypes())
            .eq("yujia_delete", yujia.getYujiaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujiaEntity yujiaEntity = yujiaService.selectOne(queryWrapper);
        if("".equals(yujia.getYujiaPhoto()) || "null".equals(yujia.getYujiaPhoto())){
                yujia.setYujiaPhoto(null);
        }
        if(yujiaEntity==null){
            yujiaService.updateById(yujia);//根据id更新
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
        List<YujiaEntity> oldYujiaList =yujiaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YujiaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YujiaEntity yujiaEntity = new YujiaEntity();
            yujiaEntity.setId(id);
            yujiaEntity.setYujiaDelete(2);
            list.add(yujiaEntity);
        }
        if(list != null && list.size() >0){
            yujiaService.updateBatchById(list);
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
            List<YujiaEntity> yujiaList = new ArrayList<>();//上传的东西
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
                            YujiaEntity yujiaEntity = new YujiaEntity();
//                            yujiaEntity.setYujiaName(data.get(0));                    //瑜伽名称 要改的
//                            yujiaEntity.setYujiaPhoto("");//详情和图片
//                            yujiaEntity.setYujiaTypes(Integer.valueOf(data.get(0)));   //瑜伽类型 要改的
//                            yujiaEntity.setYujiaAddress(data.get(0));                    //场地信息 要改的
//                            yujiaEntity.setJiaolianId(Integer.valueOf(data.get(0)));   //教练 要改的
//                            yujiaEntity.setYujiaClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            yujiaEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            yujiaEntity.setYujiaDelete(1);//逻辑删除字段
//                            yujiaEntity.setYujiaContent("");//详情和图片
//                            yujiaEntity.setCreateTime(date);//时间
                            yujiaList.add(yujiaEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yujiaService.insertBatch(yujiaList);
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
        List<YujiaView> returnYujiaViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = yujiaOrderService.queryPage(params1);
        List<YujiaOrderView> orderViewsList =(List<YujiaOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YujiaOrderView orderView:orderViewsList){
            Integer yujiaTypes = orderView.getYujiaTypes();
            if(typeMap.containsKey(yujiaTypes)){
                typeMap.put(yujiaTypes,typeMap.get(yujiaTypes)+1);
            }else{
                typeMap.put(yujiaTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yujiaTypes",type);
            PageUtils pageUtils1 = yujiaService.queryPage(params2);
            List<YujiaView> yujiaViewList =(List<YujiaView>)pageUtils1.getList();
            returnYujiaViewList.addAll(yujiaViewList);
            if(returnYujiaViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yujiaService.queryPage(params);
        if(returnYujiaViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYujiaViewList.size();//要添加的数量
            List<YujiaView> yujiaViewList =(List<YujiaView>)page.getList();
            for(YujiaView yujiaView:yujiaViewList){
                Boolean addFlag = true;
                for(YujiaView returnYujiaView:returnYujiaViewList){
                    if(returnYujiaView.getId().intValue() ==yujiaView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYujiaViewList.add(yujiaView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYujiaViewList = returnYujiaViewList.subList(0, limit);
        }

        for(YujiaView c:returnYujiaViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYujiaViewList);
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
        PageUtils page = yujiaService.queryPage(params);

        //字典表数据转换
        List<YujiaView> list =(List<YujiaView>)page.getList();
        for(YujiaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YujiaEntity yujia = yujiaService.selectById(id);
            if(yujia !=null){

                //点击数量加1
                yujia.setYujiaClicknum(yujia.getYujiaClicknum()+1);
                yujiaService.updateById(yujia);

                //entity转view
                YujiaView view = new YujiaView();
                BeanUtils.copyProperties( yujia , view );//把实体数据重构到view中

                //级联表
                    JiaolianEntity jiaolian = jiaolianService.selectById(yujia.getJiaolianId());
                if(jiaolian != null){
                    BeanUtils.copyProperties( jiaolian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaolianId(jiaolian.getId());
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
    public R add(@RequestBody YujiaEntity yujia, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yujia:{}",this.getClass().getName(),yujia.toString());
        Wrapper<YujiaEntity> queryWrapper = new EntityWrapper<YujiaEntity>()
            .eq("yujia_name", yujia.getYujiaName())
            .eq("yujia_types", yujia.getYujiaTypes())
            .eq("yujia_address", yujia.getYujiaAddress())
            .eq("jiaolian_id", yujia.getJiaolianId())
            .eq("yujia_clicknum", yujia.getYujiaClicknum())
            .eq("shangxia_types", yujia.getShangxiaTypes())
            .eq("yujia_delete", yujia.getYujiaDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YujiaEntity yujiaEntity = yujiaService.selectOne(queryWrapper);
        if(yujiaEntity==null){
            yujia.setYujiaDelete(1);
            yujia.setCreateTime(new Date());
        yujiaService.insert(yujia);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
