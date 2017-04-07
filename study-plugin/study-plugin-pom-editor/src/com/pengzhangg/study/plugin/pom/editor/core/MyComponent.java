package com.pengzhangg.study.plugin.pom.editor.core;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * Author:Zhang Peng
 * Date:2017/4/7 0007
 * Description:TODO
 */
public class MyComponent implements ApplicationComponent {
    public MyComponent() {
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "MyComponent";
    }

    public void sayHello() {
        Messages.showMessageDialog("Hello World!", "Sample", Messages.getInformationIcon());
    }
}
