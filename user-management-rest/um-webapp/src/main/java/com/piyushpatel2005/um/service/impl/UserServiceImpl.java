package com.piyushpatel2005.um.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piyushpatel2005.common.persistence.service.AbstractService;
import com.piyushpatel2005.um.persistence.dao.IUserJpaDao;
import com.piyushpatel2005.um.persistence.model.User;
import com.piyushpatel2005.um.service.IUserService;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserJpaDao dao;

    public UserServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public User findByName(final String name) {
        return dao.findByName(name);
    }

    // other

    // Spring

    @Override
    protected final IUserJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return dao;
    }
}