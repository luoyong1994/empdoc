package com.ynet.empdoc;

import com.ynet.empdoc.dao.EmpdocManagerDao;
import com.ynet.empdoc.entity.Component;
import com.ynet.empdoc.entity.ComponentType;
import com.ynet.empdoc.service.EmpdocManagerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmpdocApplicationTests {

    @Autowired
    private EmpdocManagerService empdocManagerService;

    @Autowired
    private EmpdocManagerDao empdocManagerDao;

    @Test
    public void contextLoads() {

    }

    @Test
    public void queryComponentTypeAndComponent(){
        List<Map<String,String>> list = empdocManagerDao.queryComponentTypeAndComponent();
        log.info("组件分类和类型集合：{}",list);
    }

    @Test
    public void queryComponentTypeList(){
        log.info("类型集合：{}",empdocManagerDao.queryComponentTypeList(new ComponentType()));
    }

    @Test
    public void addComponentType(){
        ComponentType componentType = new ComponentType();
        componentType.setName("常用组件");
        empdocManagerDao.addComponentType(componentType);
    }

    @Test
    public void addComponent(){
        for(int i=0;i<1;i++){
            Component component = new Component();
            component.setBasicUse("略");
            component.setComponentId("StartAction");
            component.setImpl("com.ecc.emp.flow.EMPStartAction[emp.jar]");
            component.setType(1);
            component.setIntroduce("单个业务流程（op）的入口，新建业务逻辑的时候默认添加，一个业务流程有且只有一个。");
            component.setNotices("一个业务流程有且只有一个");
            component.setName("开始");
            component.setVersion(1);
            component.setResult("0");
            empdocManagerDao.addComponent(component);
        }

    }




}
