package com.mood.user.service.impl;

import com.google.common.base.Preconditions;
import com.mood.base.BaseVO;
import com.mood.base.Result;
import com.mood.base.StateCode;
import com.mood.user.dao.AdminDao;
import com.mood.user.dao.entity.AdminPO;
import com.mood.user.service.AdminService;
import com.mood.user.service.command.LoginCommand;
import com.mood.user.service.vo.AdminInfo;
import com.mood.user.service.vo.AdminVO;
import com.mood.user.service.vo.LoginVO;
import com.mood.utils.DESUtil;
import com.mood.utils.OrikaMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public AdminVO insert(AdminPO request){
//        AdminPO admin = OrikaMapper.map(request, AdminPO.class);
//        admin.setId(IdGen.uuid());
//        adminDao.save(admin);
//        return OrikaMapper.map(admin, AdminVO.class);
//
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public AdminVO update(AdminPO request){
//        AdminPO admin = OrikaMapper.map(request, AdminPO.class);
//        adminDao.save(admin);
//        return OrikaMapper.map(admin, AdminVO.class);
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void delete(Admin request){
//        adminDao.deleteById(request.getId());
//        Shift.fatal(StatusCode.OK);
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public Admin select(Admin request){
//        Admin admin = adminDao.selectById(request.getId());
//        return OrikaMapper.map(admin, Admin.class);
//    }
//
    @Override
    public AdminVO selectById(Integer id){
        return OrikaMapper.map(adminDao.findById(id).get(), AdminVO.class);
    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public Admin selectList(Admin request){
//        Admin admin = OrikaMapper.map(request, Admin.class);
//        List<Admin> adminList = adminDao.selectAll(admin);
//        List<Admin> detailsList = OrikaMapper.mapList(adminList, Admin.class);
//        Admin response = new Admin();
//        return response;
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public Admin selectPager(Admin request){
//        Admin admin = OrikaMapper.map(request, Admin.class);
//        Pager<Admin> pager = OrikaMapper.map(request, Pager.class);
//        pager.setObject(admin);
//        pager = adminDao.selectPager(pager);
//        List<Admin> detailsList = OrikaMapper.mapList(pager.getData(), Admin.class);
//        Admin response = OrikaMapper.map(pager, Admin.class);
//        return response;
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public RegisterResponse register(RegisterRequest request) {
//        Preconditions.checkNotNull(request);
//        final Admin dbAdmin = selectByUsername(request.getUsername());
//        if (dbAdmin != null) {
//            Shift.fatal(StatusCode.USER_EXISTS);
//        }
//        // 重新计算密码
//        final Admin transientUser = OrikaMapper.map(request, Admin.class);
//        final String salt = generateRandomPasswordSalt();
//        final String loginPassword = digestWithSalt(request.getPassword(), salt);
//
//        transientUser.setId(IdGen.uuid());
//        transientUser.setSalt(salt);
//        transientUser.setPassword(loginPassword);
//        transientUser.setDelStatus(0);
//        transientUser.setCreateTime(System.currentTimeMillis());
//        transientUser.setUpdateTime(System.currentTimeMillis());
//        transientUser.setCreatePerson(transientUser.getId());
//        transientUser.setUpdatePerson(transientUser.getId());
//        adminDao.insert(transientUser);
//        return OrikaMapper.map(transientUser, RegisterResponse.class);
//    }

    /**
     * 登录接口
     * @param request
     * @return
     */
    @Override
    public BaseVO login(LoginCommand request){
        Preconditions.checkNotNull(request);
        final AdminVO adminVO = selectByUsername(request.getUsername());
        if (adminVO == null) {
            return Result.error(StateCode.USER_NOT_EXISTS);
        }
        final String salt = adminVO.getSalt();
        final String loginPassword = digestWithSalt(request.getPassword(), salt);

        if (!loginPassword.equals(adminVO.getPassword())) {
            return Result.error(StateCode.INVALID_CREDENTIAL);
        }
        String tokenStr = adminVO.getId() + ":" + System.currentTimeMillis();
        String token  = DESUtil.encrypt(tokenStr);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setAdminInfo(OrikaMapper.map(adminVO, AdminInfo.class));
        return Result.success(loginVO);
    }

    private String digestWithSalt(String content, String key) {
        String result = content;
        for (int i = 0; i < 5; i++) {
            result = DigestUtils.sha256Hex(result + key);
        }
        return result;
    }

    /**
     * 根据手机号获取用户
     * @param username
     * @return
     */
    @Override
    public AdminVO selectByUsername(String username) {
        AdminPO admin = new AdminPO();
        admin.setUsername(username);
        Example<AdminPO> example = Example.of(admin);
        Optional<AdminPO> optional = adminDao.findOne(example);
        if(optional.isPresent()){
            return OrikaMapper.map(optional.get(), AdminVO.class);
        }
        return null;
    }

//    private String digestWithSalt(String content, String key) {
//        String result = content;
//        for (int i = 0; i < 5; i++) {
//            result = DigestUtils.sha256Hex(result + key);
//        }
//        return result;
//    }
//
//    private String generateRandomPasswordSalt() {
//        return DigestUtils.sha256Hex(String.valueOf(System.nanoTime()));
//    }

}
