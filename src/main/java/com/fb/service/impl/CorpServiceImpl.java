package com.fb.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.Page;
import com.fb.dao.AuxiliaryDao;
import com.fb.dao.TCorpDao;
import com.fb.dao.TDeptDao;
import com.fb.domain.po.TCorp;
import com.fb.service.CorpService;
import com.fb.service.SimpServiceAbstract;

@Service
public class CorpServiceImpl extends SimpServiceAbstract implements CorpService {
    
    @Autowired
    private TCorpDao corpDao;
    
    @Autowired
    private AuxiliaryDao auxiliaryDao;
    
    @Autowired
    private TDeptDao deptDao;
    
    public TCorp getCorpByUid(String uid) {
        return corpDao.getCorpByUid(uid);
    }
    
    @Transactional
    public synchronized boolean addCorp(TCorp corp) {
        int count = auxiliaryDao.checkDataRepeat("t_corp", "ccode", corp.getCcode());
        int count1 = auxiliaryDao.checkDataRepeat("t_corp", "cname", corp.getCname());
        if (count + count1 > 0) {
            return false;
        } else {
            corp.setUid(DataUtils.newUUID());
            corp.setDcreatetime(new Date());
            corp.setDupdatetime(new Date());
            int count2 = corpDao.addCorp(corp);
            if (count2 > 0) return true;
        }
        return false;
    }
    
    public Page<TCorp> getCorpPage(TCorp corp, int currentPage) {
        int totalRow = corpDao.getCorpCount(corp);
        Page<TCorp> page = new Page<TCorp>(getDefaultPagesize(), currentPage, totalRow);
        page.setResultRows(corpDao.getCorpListPage(corp, page.getStartRow(), page.getPageSize()));
        return page;
    }
    
    @Transactional
    public synchronized boolean deleteCorpByUid(String uid) {
        int deptCount = deptDao.getDeptCountByUCorpId(uid);
        if (deptCount > 0) {
            return false;
        } else {
            int deleteCount = corpDao.deleteCorpByUid(uid);
            if (deleteCount > 0) return true;
        }
        return false;
    }
    
    @Transactional
    public boolean updateCorp(TCorp corp) {
        corp.setDupdatetime(new Date());
        return corpDao.updateCorp(corp) > 0 ? true : false;
    }
    
}
