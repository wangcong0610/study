package com.pengzhangg.study.plugin.pom.editor.core.Action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.pengzhangg.study.plugin.pom.editor.core.MyComponent;

/**
 * Author:Zhang Peng
 * Date:2017/4/7 0007
 * Description:TODO
 */
public class SayHelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Application application = ApplicationManager.getApplication();
        MyComponent myComponent = application.getComponent(MyComponent.class);
        myComponent.sayHello();
    }
}
