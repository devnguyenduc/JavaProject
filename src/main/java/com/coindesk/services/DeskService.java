package com.coindesk.services;

import com.coindesk.module.StringUtil;

public interface DeskService<T> {
    String success = new StringUtil().validKeyWhenSuccess();
    String fail = new StringUtil().validKeyWhenFail();

    String insert(T temp);

    Iterable<T> search();

    T searchID(long id);

    String change(long id,T temp);

    String delete(long id,T temp);
}