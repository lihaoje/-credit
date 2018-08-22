package com.atguigu.credit.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.credit.bean.NplmLoanContract;
import com.atguigu.credit.manage.mapper.ManageMapper;
import com.atguigu.credit.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<NplmLoanContract> selectContract() {
        return manageMapper.selectAll();
    }

    @Override
    public List<NplmLoanContract> selectNplmLoanContractList() {
        List<NplmLoanContract> nplmLoanContractList = manageMapper.selectNplmLoanContractList();
        return nplmLoanContractList;
    }

    @Override
    public List<NplmLoanContract> selectContractByRequirement(NplmLoanContract nplmLoanContract) {
        return  manageMapper.selectContractByRequirement(nplmLoanContract);

    }
}
