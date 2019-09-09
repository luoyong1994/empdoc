package com.ynet.empdoc.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.empdoc.dao.EmpdocManagerDao;
import com.ynet.empdoc.entity.Component;
import com.ynet.empdoc.entity.ComponentType;
import com.ynet.empdoc.entity.ComponentVO;
import com.ynet.empdoc.service.EmpdocManagerService;
import com.ynet.empdoc.util.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("empdocManagerServiceImpl")
@Slf4j
public class EmpdocManagerServiceImpl implements EmpdocManagerService {

    @Resource
    private EmpdocManagerDao empdocManagerDao;

    @Override
    public void addComponentType(ComponentType componentType) {
        log.info("添加组件类别：{}", componentType.toString());
        empdocManagerDao.addComponentType(componentType);
    }

    @Override
    public List<ComponentType> queryComponentTypeList(ComponentType componentType) {
        return empdocManagerDao.queryComponentTypeList(componentType);
    }

    @Override
    public void addComponent(ComponentVO componentVO) {
        Component component = new Component();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String inputParams = objectMapper.writeValueAsString(componentVO.getInputParams());
            String outputParams = objectMapper.writeValueAsString(componentVO.getOutputParams());
            component.setInputParams(inputParams);
            component.setOutputParams(outputParams);
        } catch (JsonProcessingException e) {
            log.info("添加组件序列化输入输出参数错误，错误原因:{}", e);
        }
        component.setVersion(1);//默认版本是1
        component.setIntroduce(componentVO.getIntroduce());
        component.setName(componentVO.getName());
        component.setImpl(componentVO.getImpl());
        component.setBasicUse(componentVO.getBasicUse());
        component.setType(Integer.valueOf(componentVO.getType()));
        component.setNotices(componentVO.getNotices());
        component.setResult(componentVO.getResult());
        component.setComponentId(componentVO.getComponentId());
        component.setSubmitTime(Timer.getTime());
        log.info("添加的组件：{}", component.toString());
        empdocManagerDao.addComponent(component);
    }

    @Override
    public void updateComponent(ComponentVO componentVO) {
        Component component = new Component();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String inputParams = objectMapper.writeValueAsString(componentVO.getInputParams());
            String outputParams = objectMapper.writeValueAsString(componentVO.getOutputParams());
            component.setInputParams(inputParams);
            component.setOutputParams(outputParams);
        } catch (JsonProcessingException e) {
            log.info("更新组件序列化输入输出参数错误，错误原因:{}", e);
        }
        int version = componentVO.getVersion();
        component.setVersion(version + 1);//默认版本是1
        component.setIntroduce(componentVO.getIntroduce());
        component.setName(componentVO.getName());
        component.setImpl(componentVO.getImpl());
        component.setBasicUse(componentVO.getBasicUse());
        component.setType(Integer.valueOf(componentVO.getType()));
        component.setNotices(componentVO.getNotices());
        component.setResult(componentVO.getResult());
        component.setComponentId(componentVO.getComponentId());
        component.setSubmitTime(Timer.getTime());
        component.setId(componentVO.getId());
        log.info("更新组件：{}", component.toString());
        empdocManagerDao.updateComponent(component);
    }

    @Override
    public List<Component> queryComponentList(Component component) {
        return empdocManagerDao.queryComponentList(component);
    }

    @Override
    public List<Object> queryComponentTypeAndComponent() {
        List<Map<String, String>> list = empdocManagerDao.queryComponentTypeAndComponent();
        List<Map<String, Object>> notComponentList = empdocManagerDao.queryComponentTypeNotInComponent();
        Iterator<Map<String, String>> iterator = list.iterator();
        Map<String, String> namesMap = new HashMap<>();
        Map<String, Map<String, Object>> idsMap = new HashMap<>();
        while (iterator.hasNext()) {
            Map<String, String> next = iterator.next();
            namesMap.put(next.get("componentTypeId"), next.get("componenTypeName"));
            if (!idsMap.containsKey(next.get("componentTypeId"))) {
                List<Map<String, String>> subList = new ArrayList<>();
                subList.add(next);
                Map<String, Object> subMap = new HashMap<>();
                subMap.put("components", subList);
                subMap.put("componenTypeName", next.get("componenTypeName"));
                idsMap.put(next.get("componentTypeId"), subMap);
            } else {
                Map<String, Object> subMap = idsMap.get(next.get("componentTypeId"));
                List<Map<String, String>> subList = (List<Map<String, String>>) subMap.get("components");
                subList.add(next);
            }
        }
        List<Object> objects = Arrays.asList(idsMap.values().toArray());
        return objects;
    }
}
