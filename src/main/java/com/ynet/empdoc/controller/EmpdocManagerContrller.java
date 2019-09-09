package com.ynet.empdoc.controller;


import com.ynet.empdoc.entity.Component;
import com.ynet.empdoc.entity.ComponentType;
import com.ynet.empdoc.entity.ComponentVO;
import com.ynet.empdoc.service.EmpdocManagerService;
import com.ynet.empdoc.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("manage/")
@Slf4j
public class EmpdocManagerContrller {


    @Resource(name = "empdocManagerServiceImpl")
    public EmpdocManagerService empdocManagerService;

    /**
     * 添加类别
     * @param componentType
     * @return
     */
    @RequestMapping("addComponentType.do")
    public JsonResult addComponentType(ComponentType componentType){
        empdocManagerService.addComponentType(componentType);
        return new JsonResult();
    }

    /**
     * 单独查询组件类别
     * @param componentType
     * @return
     */
    @RequestMapping("queryComponentTypeList.do")
    public JsonResult queryComponentTypeList(ComponentType componentType){
        List<ComponentType> componentTypes = empdocManagerService.queryComponentTypeList(componentType);
        return new JsonResult(componentTypes);
    }

    /**
     * 添加组件
     * @param componentVO
     * @return
     */
    @RequestMapping("addComponent.do")
    public JsonResult addComponent(ComponentVO componentVO){
        log.info("接受组件参数：{}",componentVO.toString());
        empdocManagerService.addComponent(componentVO);
        return new JsonResult();
    }


    /**
     * 查询组件列表
     * @param component
     * @return
     */
    @RequestMapping("queryComponentList.do")
    public JsonResult queryComponentList(Component component){
        List<Component> components = empdocManagerService.queryComponentList(component);
        return new JsonResult(components);
    }

    /**
     * 查询组件分类和组件列表，组装级联关系
     * @return
     */
    @RequestMapping("queryComponentTypeAndComponent.do")
    public JsonResult queryComponentTypeAndComponent(){
        List<Object> objects = empdocManagerService.queryComponentTypeAndComponent();
        return new JsonResult(objects);
    }

    /**
     *更新組件信息
     * @return
     */
    @RequestMapping("updateComponent.do")
    public JsonResult updateComponent(ComponentVO componentVO){
        empdocManagerService.updateComponent(componentVO);
        return new JsonResult();
    }

}
