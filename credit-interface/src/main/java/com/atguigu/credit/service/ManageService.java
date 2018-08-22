package com.atguigu.credit.service;

import com.atguigu.credit.bean.NplmLoanContract;

import java.util.List;

public interface ManageService {
    List<NplmLoanContract> selectContract();

    List<NplmLoanContract> selectNplmLoanContractList();

    List<NplmLoanContract> selectContractByRequirement(NplmLoanContract nplmLoanContract);
}
