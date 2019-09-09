package com.ynet.empdoc.dao;

import com.ynet.empdoc.entity.Component;
import com.ynet.empdoc.entity.ComponentType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpdocManagerDao {

    public void addComponentType(ComponentType componentType);

    public List<ComponentType> queryComponentTypeList(ComponentType componentType);

    public void addComponent(Component component);

    public List<Component> queryComponentList(Component component);

    public List<Map<String,String>> queryComponentTypeAndComponent();

    public List<Map<String,Object>> queryComponentTypeNotInComponent();

    public void updateComponent(Component component);
}
