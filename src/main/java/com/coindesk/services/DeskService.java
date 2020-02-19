package com.coindesk.services;

import com.coindesk.model.Customer;
import com.coindesk.module.StringUtil;

import java.util.List;

public interface DeskService<T> {
    String success = new StringUtil().validKeyWhenSuccess();
    String fail = new StringUtil().validKeyWhenFail();

    List<T> search();

    T searchID(long id);

    String change(long id,T temp);

    String delete(long id,T temp);
}
