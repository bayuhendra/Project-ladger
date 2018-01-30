/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.main.viewmodel;

import com.ledger.shared.zul.CommonViewModel;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Window;

/**
 *
 * @author HeriT
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TestVM {

    private String tulisan1 = "Create";
    private String tulisan2 = "Search";
    private String hello = "Hello Modal";

    @Command("buttonSearch")
    @NotifyChange("tulisan1")
    public void buttonSearch(@ContextParam(ContextType.VIEW) Window window) {
        tulisan1 = "Search";
    }

    @Command("buttonCreate")
    @NotifyChange("tulisan2")
    public void buttonCreate(@ContextParam(ContextType.VIEW) Window window) {
        tulisan2 = "Create";
    }

    @Command("buttonShowModal")
    @NotifyChange("tulisan2")
    public void buttonShowModal(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        tulisan2 = "Create";
        params.put(tulisan2, tulisan2);
        CommonViewModel.navigateToWithoutDetach("/form/employee/popup_employee.zul", window, params);
    }

    @Command("buttonCancel")
    @NotifyChange("*")
    public void buttonCancel(@ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    public String getTulisan1() {
        return tulisan1;
    }

    public void setTulisan1(String tulisan1) {
        this.tulisan1 = tulisan1;
    }

    public String getTulisan2() {
        return tulisan2;
    }

    public void setTulisan2(String tulisan2) {
        this.tulisan2 = tulisan2;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

}
