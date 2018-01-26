package com.ledger.acm.api.model;

/**
 *
 * @author lintang
 */
public interface ACMCallBack <T> {

    T executeInACMContext();
}
