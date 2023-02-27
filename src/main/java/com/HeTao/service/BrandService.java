package com.HeTao.service;

import com.HeTao.pojo.Brand;
import com.HeTao.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> SelectAll();
    void addBrand(Brand brand);
    void deleteById(int[] ids);

    /**
     * ��ҳ��ѯ
     * @param currentPage ��ǰҳ��
     * @param pageSize ÿҳ����
     * @return  PageBean<Brand>
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * ������ѯ
     * @param currentPage ��ǰҳ��
     * @param pageSize ÿҳ����
     * @param brand ��װ��brand����
     * @return PageBean<Brand>
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);

    Brand selectById(int id);

    void update(Brand brand);


}
