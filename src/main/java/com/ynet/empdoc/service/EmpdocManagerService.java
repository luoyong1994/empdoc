package com.ynet.empdoc.service;

import com.ynet.empdoc.entity.Component;
import com.ynet.empdoc.entity.ComponentType;
import com.ynet.empdoc.entity.ComponentVO;

import java.util.List;

public interface EmpdocManagerService {
    public void addComponentType(ComponentType componentType);

    public List<ComponentType> queryComponentTypeList(ComponentType componentType);

    public void addComponent(ComponentVO componentVO);

    public void updateComponent(ComponentVO componentVO);

    public List<Component> queryComponentList(Component component);

    public List<Object> queryComponentTypeAndComponent();
}
