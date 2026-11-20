
package com.adobe.aem.guides.demo.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HeroModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ChildResource(name = "buttons")
    private List<HeroButtonModel> buttons;

    private boolean hasTitle;
    private boolean hasDescription;

    @PostConstruct
    protected void init() {
        hasTitle = title != null && !title.trim().isEmpty();
        hasDescription = description != null && !description.trim().isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isHasTitle() {
        return hasTitle;
    }

    public boolean isHasDescription() {
        return hasDescription;
    }

    public List<HeroButtonModel> getButtons() {
        return buttons;
    }
}
