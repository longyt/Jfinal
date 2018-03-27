package com.zking.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.zking.Model.Student;
import com.zking.controller.IndexController;

/**
 * @author: longyt
 * @create: 2018-01-18 15:29
 * @desc:
 **/
public class indexConfig extends JFinalConfig{
    public void configConstant(Constants constants) {
        constants.setDevMode(true);//开发者模式
        constants.setViewType(ViewType.JSP);//
        PropKit.use("db.properties");

    }

    public void configRoute(Routes routes) {
        routes.add("person", IndexController.class);
    }

    public void configPlugin(Plugins plugins) {
        C3p0Plugin c3p0Plugin=new C3p0Plugin(PropKit.get("url"),PropKit.get("user"),PropKit.get("pass"));
        ActiveRecordPlugin activeRecordPlugin=new ActiveRecordPlugin(c3p0Plugin);
        activeRecordPlugin.setShowSql(true);
        activeRecordPlugin.addMapping("student","sid", Student.class);

        plugins.add(c3p0Plugin);
        plugins.add(activeRecordPlugin);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
