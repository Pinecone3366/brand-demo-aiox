package com.HeTao.service;

import com.HeTao.pojo.User;

public interface UserService {
    /**
     * ��¼����,ͨ���û��������¼
     * @param user ��װ�û���������
     * @return ���ض�������������
     */
    User select(User user);

    /**
     * ע�Ṧ��,ͨ���û�������ע��
     * @param user ��װ�û���������
     */
    void add(User user);

}
