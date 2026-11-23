
package com.adobe.aem.guides.demo.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CardModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String imagePath;

    @ValueMapValue
    private String ctaLabel;

    @ValueMapValue
    private String ctaUrl;

    @ValueMapValue
    private boolean openInNewTab;

    private boolean hasTitle;
    private boolean hasDescription;
    private boolean hasImage;
    private boolean hasCta;

    @PostConstruct
    protected void init() {

        hasTitle = title != null && !title.trim().isEmpty();

        hasDescription = description != null
                && !description.trim().isEmpty();

        hasImage = imagePath != null
                && !imagePath.trim().isEmpty();

        hasCta = ctaLabel != null
                && !ctaLabel.trim().isEmpty()
                && ctaUrl != null
                && !ctaUrl.trim().isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCtaLabel() {
        return ctaLabel;
    }

    public String getCtaUrl() {
        return ctaUrl;
    }

    public boolean isOpenInNewTab() {
        return openInNewTab;
    }

    public boolean isHasTitle() {
        return hasTitle;
    }

    public boolean isHasDescription() {
        return hasDescription;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public boolean isHasCta() {
        return hasCta;
    }
}

