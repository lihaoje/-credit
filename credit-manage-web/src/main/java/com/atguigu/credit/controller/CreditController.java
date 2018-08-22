package com.atguigu.credit.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.credit.bean.NplmLoanContract;
import com.atguigu.credit.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CreditController {

    @Reference
    private ManageService manageService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("fk")
    public String fangkuan(){
        return "fk";
    }

    @RequestMapping("ht")
    public String hetong(HttpServletRequest request,Integer contractNo,String userName,String idNumber){
//        List<NplmLoanContract> nplmLoanContracts = manageService.selectContract();
//        for (NplmLoanContract nplmLoanContract : nplmLoanContracts) {
//            //System.out.println(nplmLoanContract.getRepayAccountBankName());
//        }
        if (contractNo!=null||userName!=null||idNumber!=null){
            NplmLoanContract nplmLoanContract = new NplmLoanContract();
            nplmLoanContract.setLoanContractNum(contractNo);
            nplmLoanContract.setRepayAccountName(userName);
            nplmLoanContract.setRepayAcctIdenNum(idNumber);

            List<NplmLoanContract> nplmLoanContractList = manageService.selectContractByRequirement(nplmLoanContract);
            request.setAttribute("nplmLoanContracts",nplmLoanContractList);
        }else {
            List<NplmLoanContract> nplmLoanContracts = manageService.selectNplmLoanContractList();
            request.setAttribute("nplmLoanContracts", nplmLoanContracts);
        }
        return "ht";
    }

//    @RequestMapping("searchInfo")
//    @ResponseBody
//    public List<NplmLoanContract> searchInfo(Integer contractNo,String uerName,String idNumber){
//        NplmLoanContract nplmLoanContract = new NplmLoanContract();
//        nplmLoanContract.setLoanContractNum(contractNo);
//        nplmLoanContract.setRepayAccountName(uerName);
//        nplmLoanContract.setRepayAcctIdenNum(idNumber);
//
//        List<NplmLoanContract> nplmLoanContractList = manageService.selectContractByRequirement(nplmLoanContract);
//        for (NplmLoanContract loanContract : nplmLoanContractList) {
//            System.out.println(loanContract);
//        }
//        return nplmLoanContractList;
//    }







    @RequestMapping("前期费用查询")
    public String qqfycx(){
        return "前期费用查询";
    }
    @RequestMapping("待还款列表")
    public String dhk(){
       return "待还款列表";
    }
    @RequestMapping("逾期列表")
    public String yq(){
       return "逾期列表";
    }

    @RequestMapping("已还款列表")
    public String yhk(){
        return "已还款列表";
    }
    @RequestMapping("扣款结果查询列表")
    public String kkjg(){
        return "扣款结果查询列表";
    }

    @RequestMapping("信托扣款明细查询")
    public String stkk(){
        return "信托扣款明细查询";
    }

    @RequestMapping("查看还款情况页面")
    public String hk(){
        return "查看还款情况页面";
    }

    @RequestMapping("修改还款情况页面")
    public String updatehk(){
        return "修改还款情况页面";
    }
}
