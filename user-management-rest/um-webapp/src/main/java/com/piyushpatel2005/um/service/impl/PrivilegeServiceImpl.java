package com.piyushpatel2005.um.service.impl;

import com.piyushpatel2005.um.persistence.dao.IPrivilegeJpaDao;
import com.piyushpatel2005.um.persistence.model.Privilege;
import com.piyushpatel2005.um.service.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piyushpatel2005.common.persistence.service.AbstractService;

@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements IPrivilegeService {

    @Autowired
    private IPrivilegeJpaDao dao;

    public PrivilegeServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    public Privilege findOneByName(final String name) {
        return getDao().findOneByName(name);
    }

    // Spring

    @Override
    protected final IPrivilegeJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
        return dao;
    }

}
