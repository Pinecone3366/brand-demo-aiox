package com.HeTao.service;

import com.HeTao.pojo.User;
import com.HeTao.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

public interface UserService {
    /**
     * ��¼����,ͨ���û��������¼
     * @param user ��װ�û���������
     * @return ���ض�������������
     */
    User select(User user);
}
